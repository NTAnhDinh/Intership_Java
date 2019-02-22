package api.managesoccer.controller;

import api.managesoccer.model.Matches;
import api.managesoccer.model.Score;
import api.managesoccer.service.MatchesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Component
@Controller
@RequestMapping("/soccer/")
@Api(description = "Functions of admin to manage the matches ", tags = { "matches" })
public class MatchesController {
	@Autowired
	MatchesService betsService;

	@GetMapping(value = "/listMatches")
	@ApiOperation("Get list matches")
	public ResponseEntity<List<Matches>> listMatches() {

		List<Matches> listBet = betsService.findAll();

		return new ResponseEntity(listBet, HttpStatus.OK);

	}

	@GetMapping(value = "/listMatch/{id}")
	@ApiOperation("Get matches by id")
	public ResponseEntity<Matches> getMatch(
			@ApiParam(value = "id of match", required = true) @PathVariable(value = "id") String id) {

		Matches trancc = betsService.findOne(Integer.parseInt(id));

		return new ResponseEntity(trancc, HttpStatus.OK);

	}

	@DeleteMapping("/deleteMatches/{id}")
	@ApiOperation("Delete a matches")
	@ApiResponse(code = 204, message = "Delete unsucessfully")
	public String deleteMatches(
			@ApiParam(value = "id of match", required = true) @PathVariable(value = "id") String id) {
		return betsService.deleteMatch(Integer.parseInt(id));

	}

	@PostMapping(value = "/createMatch/{name}/{endeddate}")
	@ApiOperation("Create a match")
	@ApiResponse(code = 200, message = "Create successfully")
	public ResponseEntity<Matches> createMatches(

			@ApiParam(value = "Name of match", required = true) @PathVariable(value = "name") String name,
			@ApiParam(value = "Ended date  of match", required = true) @PathVariable(value = "endedDate") String endedDate

	) {
		Matches match = new Matches();
		match.setNameOfMatch(name);
		match.setEndDate(endedDate);
		match.setStatus(0);
		match.setListScores(null);
//		if (betsService.isMatchExit(match)) {
//			return new ResponseEntity(null, HttpStatus.CONFLICT);
//		}
		return new ResponseEntity(betsService.saveMatch(match), HttpStatus.CREATED);

	}
}
