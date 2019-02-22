package demo.katharsis.model;

import io.katharsis.resource.annotations.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@JsonApiResource(type = "roles")
@Entity
@Table(name = "role")
public class Role implements Serializable{

    @JsonApiId
    @Id
    @Column(name = "role_id" , nullable = false, insertable = true, updatable = true)
    private Long id;
    @Basic
    @Column(name = "name" )
    private String name;

    @JsonApiRelation(lookUp=LookupIncludeBehavior.AUTOMATICALLY_WHEN_NULL,serialize=SerializeType.ONLY_ID)
    private Set<User> users;

    public Role() {
    }

    public Role(Long id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    @JoinTable(name = "user_role",joinColumns = {
            @JoinColumn(name = "role_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "user_id",nullable = false, updatable = false) })
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
