package api.managesoccer.service;

import api.managesoccer.model.Matches;
import api.managesoccer.model.Score;
import api.managesoccer.repository.BetsRepository;
import api.managesoccer.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MatchesService {
	@Autowired
	MatchesRepository matchesRepo;

	@Autowired
	ScoreService scoreService;

	public List<Matches> findAll() {

		return matchesRepo.findAll();

	}

	public Matches findOne(int id) {

		return matchesRepo.getOne(id);

	}

//	public boolean isMatchExit(Matches match) {
//		List<Matches> list = findAll();
//		for (Matches d : list) {
//			if (match.equals(d))
//				return true;
//		}
//		return false;
//	}


	public Matches saveMatch(Matches match) {
		return matchesRepo.save(match);

	}

	public String deleteMatch(int id) {
		String mess = "";
		Matches entity = findOne(id);

		if (entity == null)
			mess = "Unsuccessfull";

		else {

			matchesRepo.delete(entity);
			mess = "Successfull";

		}
		return mess;
	}

	public boolean isExpirationDate(String expirationDate) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date1 = null;
		try {
			date =dateFormat.parse(dateFormat.format(date));
			date1 = dateFormat.parse(expirationDate);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (date.equals(date1)) {
			return true;
		}

		return date.after(date1);
	}

	public Matches getListMatchExpried() {
		List<Matches> listAllMatches = findAll();
		for (Matches m : listAllMatches) {
			if(isExpirationDate(m.getEndDate()) && m.getStatus()==0){
				return m;
			}
		}
		return null;
	}


	// kiem tra cac tiso cua 1 tran dau chua duoc update trang thai win truoc do
	public boolean isStatusScore(int matchId) {
		List<Score> listScores = scoreService.getListScore(matchId);
		for (Score score : listScores) {
			if (score.getIsWin() == 1)
				return false;
		}
		return true;
	}
}
