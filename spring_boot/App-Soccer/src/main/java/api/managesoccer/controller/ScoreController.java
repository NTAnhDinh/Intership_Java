package api.managesoccer.controller;

import api.managesoccer.model.*;
import api.managesoccer.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/soccer/")
@Api(description = "Everything about score", tags = { "score" })
public class ScoreController {
	@Autowired
	ScoreService scoreService;

	@GetMapping(value = "/scores")
	@ApiOperation("Get list scores")
	public ResponseEntity<List<Score>> listScores() {

		List<Score> listScore = scoreService.findAll();

		if (listScore.isEmpty()) {

			return new ResponseEntity(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(listScore, HttpStatus.OK);

	}

	@GetMapping(value = "/score/{id}")
	@ApiOperation("Get score by id")
	public ResponseEntity<Score> getScoreById(
			@ApiParam(value = "id of a score object", required = true) @PathVariable(value = "id") String scoreId) {

		Score score = scoreService.findOne(Integer.parseInt(scoreId));

		return new ResponseEntity(score, HttpStatus.OK);

	}

	@DeleteMapping("/deleteScore/{id}")
	@ApiOperation("Delete a score")
	@ApiResponse(code = 204, message = "Delete unsucessfully")
	public boolean deletePlayer(
			@ApiParam(value = "id of a score object", required = true) @PathVariable(value = "id") String id) {

		return scoreService.deleteScore(Integer.parseInt(id));

	}

	@PostMapping(value = "/createScore/{score1}/{score2}/{ratio}/{price}/{matchId}")
	@ApiOperation("Create a score")
	@ApiResponse(code = 200, message = "Create successfully")
	public ResponseEntity<Score> createScore(
			
			@ApiParam(value = "first score", required = true) @PathVariable(value = "score1") String score1,
			@ApiParam(value = "second score", required = true) @PathVariable(value = "score2") String score2,
			@ApiParam(value = "ratio of score", required = true) @PathVariable(value = "ratio") String ratio,
			@ApiParam(value = "price of a score", required = true) @PathVariable(value = "price") String price,
			@ApiParam(value = "id of match", required = true) @PathVariable(value = "matchId") String matchId) {
		Score score = new Score();
		score.setScore1(Integer.parseInt(score1));
		score.setScore2(Integer.parseInt(score2));
		score.setRatio(Integer.parseInt(ratio));
		score.setPrice(Integer.parseInt(price));
		score.setIsWin(0);
		return new ResponseEntity(scoreService.saveScore(score, Integer.parseInt(matchId)), HttpStatus.CREATED);

	}
}
