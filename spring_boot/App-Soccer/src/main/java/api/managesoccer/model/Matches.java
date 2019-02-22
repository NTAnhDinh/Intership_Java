package api.managesoccer.model;

import com.fasterxml.jackson.annotation.*;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity
@Table(name = "matches")
public class Matches implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "false")
    @ApiModelProperty(value="id of match to represent a match")
    @Column(name = "id_match")
    int matchId;

    @ApiModelProperty(value="name of match ")
    @Column(name = "name_match")
    String nameOfMatch;

    @Column(name = "ended_date")
    String endDate;
    @Column(name = "status")
    int status;
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    List<Score> listScores;

    public Matches() {
    }


    public Matches(int matchId, String nameOfMatch, String endDate, int status, List<Score> listScores) {
        super();
        this.matchId = matchId;
        this.nameOfMatch = nameOfMatch;
        this.endDate = endDate;
        this.status = status;
        this.listScores = listScores;
    }


    public Matches(int matchId, String nameOfMatch, String endDate, int status) {
		super();
		this.matchId = matchId;
		this.nameOfMatch = nameOfMatch;
		this.endDate = endDate;
		this.status = status;
	}


	public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public List<Score> getListScores() {
        return listScores;
    }


    public void setListScores(List<Score> listScores) {
        this.listScores = listScores;
    }


    public int getMatchId() {
        return matchId;
    }


    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }


    public String getNameOfMatch() {
        return nameOfMatch;
    }


    public void setNameOfMatch(String nameOfMatch) {
        this.nameOfMatch = nameOfMatch;
    }


    public String getEndDate() {
        return endDate;
    }


    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
