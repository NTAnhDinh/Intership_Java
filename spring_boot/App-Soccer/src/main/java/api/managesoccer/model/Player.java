package api.managesoccer.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity

@Table(name = "player")

public class Player implements Serializable {

    /**

     *

     */

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    long balance;



    //    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "role_id",  insertable = false, updatable = false)
    private User_Role role;


    public Player() {
    }



    public Player(int id, String name, String username, String password, long balance, User_Role role) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.balance = balance;

        this.role = role;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public User_Role getRole() {
        return role;
    }



    public void setRole(User_Role role) {
        this.role = role;
    }



    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }


}
