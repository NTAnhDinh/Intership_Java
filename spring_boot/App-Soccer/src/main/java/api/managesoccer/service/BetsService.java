package api.managesoccer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.managesoccer.model.*;

import api.managesoccer.repository.BetsRepository;

import java.util.*;

@Service

public class BetsService {
    @Autowired
    BetsRepository listPlayersRepo;

    public List<Bets> findAll() {
        return listPlayersRepo.findAll();
    }

    public Bets findOne(int id) {

        return listPlayersRepo.getOne(id);

    }

    public Bets add(Bets listPlayer) {
        return listPlayersRepo.save(listPlayer);

    }

    public boolean delete(int id) {
        Bets entity = findOne(id);
        if (entity == null)
            return false;
        else {
            listPlayersRepo.delete(entity);
            return true;

        }
    }

    public int countTotalPlayerForScore(int scoreId) {
        return listPlayersRepo.countTotalPlayerForScore(scoreId);
    }

    public List<Integer> getListPlayer(int scoreId) {
        return listPlayersRepo.getListPlayer(scoreId);
    }
}
