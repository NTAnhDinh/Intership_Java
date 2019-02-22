package com.oauth.model;

import javax.persistence.*;

@Entity
@Table(name="USER_ROLES")
public class User_Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;


    public User_Role() {
    }

    public User_Role(String name) {

        this.name = name;

    }





    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }

}
