package api.managesoccer.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity

@Table(name = "score")

public class Score implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score")
    int scoreId;

    @Column(name = "score1")
    int score1;

    @Column(name = "score2")
    int score2;

    @Column(name = "ratio")
    double ratio;

    @Column(name = "price")
    int price;
    @Column(name = "is_win")
    int isWin;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_match")
    Matches match;

    public Score() {

    }



    public Score(int scoreId, int score1, int score2, double ratio, int price, int isWin, Matches match) {
        super();
        this.scoreId = scoreId;
        this.score1 = score1;
        this.score2 = score2;
        this.ratio = ratio;
        this.price = price;
        this.isWin = isWin;
        this.match = match;
    }



    public double getRatio() {

        return ratio;

    }

    public void setRatio(double ratio) {

        this.ratio = ratio;

    }

    public int getPrice() {

        return price;

    }

    public void setPrice(int price) {

        this.price = price;

    }




    public int getScoreId() {
        return scoreId;
    }



    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }



    public int getScore1() {
        return score1;
    }



    public void setScore1(int score1) {
        this.score1 = score1;
    }



    public int getScore2() {
        return score2;
    }



    public void setScore2(int score2) {
        this.score2 = score2;
    }



    public Matches getMatch() {
        return match;
    }

    public void setMatch(Matches match) {
        this.match = match;
    }

    public int getIsWin() {
        return isWin;
    }

    public void setIsWin(int isWin) {
        this.isWin = isWin;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", ratio=" + ratio +
                ", price=" + price +
                ", isWin=" + isWin +
                '}';
    }
}
