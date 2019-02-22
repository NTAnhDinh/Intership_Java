package com.tma.tlab.api.model;

import io.katharsis.resource.annotations.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@JsonApiResource(type = "users")
@Entity
@Table(name = "user")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonApiId
    @Column(name = "user_id" , nullable = false, insertable = true, updatable = true)
    private Integer user_id;
    @Column(name = "username" , nullable = false, insertable = true, updatable = true)
    private String user_name;
    @Column(name = "password" , nullable = false, insertable = true, updatable = true)
    private String password;
    @Column(name = "name" , nullable = false, insertable = true, updatable = true)
    private String name;



@JsonApiRelation(lookUp=LookupIncludeBehavior.AUTOMATICALLY_ALWAYS, serialize=SerializeType.EAGER, opposite = "subject")
private List<Subject> subjects;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {

        return user_name;
    }

    public void setUser_name(String user_name) {

        this.user_name = user_name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public User(Integer user_id, String user_name, String password, String name, List<Subject> subjects) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.subjects = subjects;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
