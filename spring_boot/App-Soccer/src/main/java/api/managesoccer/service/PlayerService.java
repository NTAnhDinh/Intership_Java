package api.managesoccer.service;

import api.managesoccer.config.UserDetailService;
import api.managesoccer.model.*;
import api.managesoccer.repository.PlayerRepository;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    private UserDetailService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    MatchesService matchService;

    @Autowired
    ScoreService scoreService;

    @Autowired
    BetsService listPlayerService;

    @Autowired
    RegisterBookieService registerBookieService;

    public static final int CODE1 = 1;
    public static final int CODE0 = 0;
    public static final double percentForBetFund = 0.15;
    public static final long remainingFund = 0;

    public List<Player> findAll() {

        return playerRepository.findAll();

    }

    public Player savePlayer(Player player) {
        player.setPassword(passwordEncoder.encode(player.getPassword()));
        return playerRepository.save(player);

    }

    public boolean deletePlayer(int id) {
        if (id <= 0)
            return false;
        Player entity = findOne(id);

        if (entity == null)

            return false;

        else {

            playerRepository.delete(entity);

            return true;

        }

    }

    public Player findOne(int id) {

        return playerRepository.getOne(id);

    }

    public Player findByUsername(String username) {

        return playerRepository.findByUserName(username);

    }

    // tru tien cua ti so da dat cuoc
    public long calculateBalance(int player_id, int scoreId) {
        Player player = findOne(player_id);
        long result;
        Score score = scoreService.findOne(scoreId);
        result = player.getBalance() - score.getPrice();
        player.setBalance(result);
        savePlayer(player);
        return result;

    }

    // lay thong tin nguoi choi
    public Player getInfo() {
        String username = userDetailsService.getUserDetail().getUsername();
        Player player = findByUsername(username);
        return player;
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String chooseScore(int tiso1, int tiso2, int match_id) {
        Player player = getInfo();
        Score score;
        String mess = "";
        int id = player.getId();
        // truong hop nguoi dung het tien thi khong cho cuoc
        if (player.getBalance() <= 0) {
            mess = "You don't have enough money to continue";
        } else {

            score = scoreService.getByScore(tiso1, tiso2, match_id);
            if (score != null) {
                List<Bets> listPlayers = listPlayerService.findAll();
                for (Bets players : listPlayers) {
                    // neu trung khong cho cuoc them
                    if (score.getScoreId() == players.getScoreId()) {
                        mess = "You choose duplicated score";
                        return mess;
                    }
                }
                // luu lai ti so da chon xuong database
                listPlayerService.add(new Bets(id, score.getScoreId(), match_id));
                // tru tien cua score do
                calculateBalance(id, score.getScoreId());
                mess = "Successful";
            }
            // truong hop khong tim thay score ma nguoi dung cuoc
            else {
                mess = "no found score";
            }

        }
        return mess;
    }

    // recharge for user
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Player recharge(int playerId, int money) {
        Player player = findOne(playerId);
        System.out.println(player.getId());
        player.setBalance(player.getBalance()+money);
        savePlayer(player);
        return player;
    }

    public int totalMoneyBetForMatch(int matchId) {

        List<Score> listScores = matchService.findOne(matchId).getListScores();

        int total = 0;

        for (Score score : listScores) {

            List<Integer> listPlayers = listPlayerService.getListPlayer(score.getScoreId());

            total += score.getPrice() * listPlayers.size();

        }
        return total;

    }

    // tinh tien thang cho moi nguoi chon duoc ti so win cua 1 tran cc
    public double chargeForPeople(int matchId, int scoreId) {

        List<Integer> listPlayers = listPlayerService.getListPlayer(scoreId);
        if (listPlayers.size() == 0) return 0;
        return ((1 - percentForBetFund) * totalMoneyBetForMatch(matchId) + remainingFund) / (listPlayers.size());

    }

    // thanh toan cho nguoi choi dat duoc ti so thang
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String calculateBalance2() {
        Matches match = matchService.getListMatchExpried();


        String mess = "";
        if (match != null) {
            Score s = scoreService.getScoreWin(match.getMatchId());
            // lay ra danh sach nguoi choi dat ti so win
            List<Integer> listPlayers = listPlayerService.getListPlayer(s.getScoreId());
            if (listPlayers.size() > 0) {
                for (Integer i : listPlayers) {
                    Player player = findOne(i);
                    player.setBalance((int) (player.getBalance()
                            + Math.round(chargeForPeople(s.getMatch().getMatchId(), s.getScoreId()))));
                    savePlayer(player);
                }
                // cap nhat trang thai tran dau ve 1 la da tinh tien roi
                Matches object = matchService.findOne(s.getMatch().getMatchId());
                object.setStatus(CODE1);
                matchService.saveMatch(object);
                calculateBalance3(s.getMatch().getMatchId());
                mess = "Successfully";
            } else {
                mess = "Error, Paid";
            }
        }
        return mess;
    }

    // cap nhat trang thai cho ti so thang cua 1 tran dau
    public Score updateStatusWinForScore(int scoreId, int matchId) {
        Score score = scoreService.findOne(scoreId);
        Matches d = matchService.findOne(matchId);
        if (score == null || d == null)
            return null;
        // kiem tra tran ca do da ket thuc chua va cac ti so cua tran đo chua co ti so
        // nao win
        if (matchService.isExpirationDate(d.getEndDate()) && matchService.isStatusScore(matchId)) {
            score.setIsWin(CODE1);

        }
        scoreService.saveScore(score);
        return score;
    }

    // tinh loi nhuan cho admin
    public Player calculateBalance3(int matchId) {
        Player player = getInfo();
        RegisterBookie r = registerBookieService.findOne(player.getId());
        Matches match = matchService.findOne(matchId);
        if (match.getEndDate() != null && matchService.isExpirationDate(match.getEndDate()) && r.getStatus() == 0) {
            player.setBalance(player.getBalance() + Math.round(percentForBetFund * totalMoneyBetForMatch(matchId)));
            savePlayer(player);
            // cap nhat trang thai admin da nhan duoc tien roi
            r.setStatus(CODE1);
            registerBookieService.saveBookie(r);
        }
        return player;
    }

    public RegisterBookie registerBookie(int matchId) {
        Player player = getInfo();
        RegisterBookie r = new RegisterBookie(player.getId(), matchId, CODE0);
        registerBookieService.saveBookie(r);
        return r;
    }

    // du doan so tien thang duoc cua tung ti so cua tran ca dang mo
    public void predictProceedsFromScore() {
        List<Matches> matchesList = matchService.findAll();
        List<Matches> results = new ArrayList<>();
        // lay ds nhung tran ca chua het han
        for (Matches m : matchesList) {
            if ( !matchService.isExpirationDate(m.getEndDate())) {
                results.add(m);
            }
        }
        System.out.println(results.size());
        if (results.size() > 0) {
            for (Matches match : results) {
                System.out.println("Tran "+match.getNameOfMatch());
                List<Score> scoreList = scoreService.getListScore(match.getMatchId());
                Map<Score, Double> listMap = new LinkedHashMap<>();
                //tinh tien cho tung ti so va dat vao listmap
                for (Score score : scoreList) {
                    double money = chargeForPeople(match.getMatchId(), score.getScoreId());
                    listMap.put(score, money);
                }
                //hien thi du lieu du doan
                Set<Score> keySet = listMap.keySet();
                for (Score key : keySet) {
                    System.out.println(key.toString() + " " + listMap.get(key));
                }
            }
        }
    }

}
