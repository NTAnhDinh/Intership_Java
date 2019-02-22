package api.managesoccer.model;

import javax.persistence.*;

@Entity
@Table(name = "registerbookie")
public class RegisterBookie {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_match")
    private int matchId;

    @Column(name = "status")
    private int status;

    public RegisterBookie() {
    }

    public RegisterBookie(int id, int matchId, int status) {
        this.id = id;
        this.matchId = matchId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
