package api.managesoccer.service;

import api.managesoccer.model.Score;
import api.managesoccer.repository.MatchesRepository;
import api.managesoccer.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScoreService {
	@Autowired
	ScoreRepository scoreRepository;
	@Autowired
	MatchesRepository matchesRepo;

	public List<Score> findAll() {

		return scoreRepository.findAll();

	}

	public Score findOne(int id) {

		return scoreRepository.getOne(id);

	}

	public Score saveScore(Score score, int matchId) {
		score.setMatch(matchesRepo.getOne(matchId));
		return scoreRepository.save(score);

	}
	public Score saveScore(Score score) {
		return scoreRepository.save(score);

	}

	public boolean deleteScore(int id) {

		Score entity = findOne(id);

		if (entity == null)

			return false;

		else {
			scoreRepository.delete(entity);
			return true;

		}

	}

	public Score getByScore(int score1, int score2, int matchId) {
		return scoreRepository.findByScore(score1, score2, matchId);
	}

	public Score getScoreWin(int matchId) {
		return scoreRepository.getScoreWin(matchId);
	}

	public List<Score> getListScore(int matchId) {
		return scoreRepository.getListScore(matchId);
	}

}
