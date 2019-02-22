package api.managesoccer.model;

import java.io.Serializable;


import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity

@Table(name = "bets")
public class Bets {


    @Id
    @Column(name = "stt")
    private int stt;
    @Column(name = "id_score")
    private int id_score;
   

    @Column(name = "id_player")
    private int playerId;

    @Column(name = "id_match")
    private int matchId;

    public Bets() {
    }


    public Bets(int stt, int playerId, int scoreId, int matchId) {
        super();
        this.stt = stt;
        this.playerId = playerId;
        this.id_score = scoreId;
        this.matchId = matchId;
    }


    public Bets(int playerId, int scoreId, int matchId) {
        super();
        this.playerId = playerId;
        this.id_score = scoreId;
        this.matchId = matchId;
    }


    public int getStt() {
        return stt;
    }


    public void setStt(int stt) {
        this.stt = stt;
    }


    public int getPlayerId() {
        return playerId;
    }


    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }


    public int getScoreId() {
        return id_score;
    }


    public void setScoreId(int scoreId) {
        this.id_score = scoreId;
    }


    public int getMatchId() {
        return matchId;
    }


    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }


}
