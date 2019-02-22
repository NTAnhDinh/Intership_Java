package api.managesoccer.controller;

import api.managesoccer.model.*;
import api.managesoccer.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/soccer/")
@Api(description = "All function that player can do", tags = {"player"})

public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping(value = "/players")
    @ApiOperation("Get list players")
    public List<Player> listAllPlayers() {
        List<Player> listScores = playerService.findAll();
        return listScores;
    }

    @GetMapping(value = "/player")
    @ApiOperation("Get infomation of player")
    public ResponseEntity<Player> getOne() {
        Player player = playerService.getInfo();
        return new ResponseEntity(playerService.findOne(player.getId()), HttpStatus.OK);

    }

    @DeleteMapping("/deletePlayer/{id}")
    @ApiOperation("Delete a player")
    @ApiResponse(code = 204, message = "Delete unsucessfully")
    public boolean deletePlayer(
            @ApiParam(value = "Id of player", required = true) @PathVariable(value = "id") String id) {
        System.out.println(id);
        return playerService.deletePlayer(Integer.parseInt(id));

    }

    @PostMapping(value = "/createPlayer")
    @ApiOperation("Create a players")
    @ApiResponse(code = 200, message = "Create successfully")
    public ResponseEntity<Player> createNguoiChoi(
            @ApiParam(value = "Object player that contain infomation of player", required = true) @RequestBody Player player) {
        player.setBalance(0);
//        player.setStatus_recharge(0);
        return new ResponseEntity(playerService.savePlayer(player), HttpStatus.CREATED);

    }

    @PostMapping(value = "/choose/{match_id}/{score1}/{score2}")
    @ApiOperation("Choose a score to bet")
    @ApiResponse(code = 201, message = "Save score sucessfully")
    public ResponseEntity<String> chooseScore(
            @ApiParam(value = "Id of match", required = true) @PathVariable(value = "match_id") String matchId,
            @ApiParam(value = "firt score", required = true) @PathVariable(value = "score1") String score1,
            @ApiParam(value = "second score", required = true) @PathVariable(value = "score2") String score2) {
        String s = playerService.chooseScore(Integer.parseInt(score1), Integer.parseInt(score2),
                Integer.parseInt(matchId));

        return new ResponseEntity(s, HttpStatus.OK);
    }

    @PutMapping(value = "/recharge/{playerId}/{money}")
    public Player recharge(
            @ApiParam(value = "playerId", required = true) @PathVariable(value = "playerId") String playerId,
            @ApiParam(value = "money", required = true) @PathVariable(value = "money") String money) {
        return playerService.recharge(Integer.parseInt(playerId), Integer.parseInt(money));
    }


    @PutMapping(value = "/updateStatusWin/{scoreId}/{matchId}")

    @ApiOperation("Update status of score")
    @ApiResponse(code = 201, message = "Update sucessfully")
    public ResponseEntity<Score> updateStatusWin(
            @ApiParam(value = "id of a score object", required = true) @PathVariable(value = "scoreId") String scoreId,
            @ApiParam(value = "id of a match object", required = true) @PathVariable(value = "matchId") String matchId) {
        Score score = playerService.updateStatusWinForScore(Integer.parseInt(scoreId), Integer.parseInt(matchId));
        return new ResponseEntity(score, HttpStatus.OK);
    }

    @PutMapping(value = "/updatePrize")
    @ApiOperation("Update Prize for players with a winning score")
    @ApiResponse(code = 201, message = "Update sucessfully")
    public ResponseEntity<String> updatePrize() {
        return new ResponseEntity(playerService.calculateBalance2(), HttpStatus.OK);
    }

    @PutMapping(value = "/registerBookie/{matchId}")
    @ApiOperation("Admin register bookie with each match")
    @ApiResponse(code = 201, message = "register sucessfully")
    public ResponseEntity<RegisterBookie> registerBookie(
            @ApiParam(value = "id of a match object", required = true) @PathVariable(value = "matchId") String matchId) {
        return new ResponseEntity(playerService.registerBookie(Integer.parseInt(matchId)), HttpStatus.OK);
    }
}
