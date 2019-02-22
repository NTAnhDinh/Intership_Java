package demo.katharsis.model;
import io.katharsis.resource.annotations.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@JsonApiResource(type = "users")
@Entity
@Table(name = "user")
public class User implements Serializable{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @JsonApiId
    @Column(name = "user_id" , nullable = false, insertable = true, updatable = true)
    private Integer user_id;
    @Basic
    @Column(name = "username" )
    private String user_name;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "name" )
    private String name;

    private Set<Role> roles;


    public User() {
    }

    public User(Integer user_id, String user_name, String password, String name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    @JsonApiRelation(serialize=SerializeType.EAGER)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
