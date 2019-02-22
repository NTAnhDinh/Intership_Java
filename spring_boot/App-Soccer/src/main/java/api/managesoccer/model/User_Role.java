package api.managesoccer.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
public class User_Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role_name")
    private String name;


    public User_Role() {
    }

    public User_Role(int id, String name, Player player) {
        this.id = id;
        this.name = name;
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

}
