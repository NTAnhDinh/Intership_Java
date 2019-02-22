package com.tma.tlab.api.model;

import io.katharsis.resource.annotations.*;

import javax.persistence.*;
import java.io.Serializable;

@JsonApiResource(type = "subjects")
@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonApiId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private Long subjectId;
    @Basic
    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 45)
    private String description;
    @JsonApiRelation (lookUp=LookupIncludeBehavior.AUTOMATICALLY_WHEN_NULL,serialize=SerializeType.ONLY_ID, opposite = "user")
    private User user;

    public Long getSubjectId() {
        return subjectId;
    }

    public String getDescription() {

        return description;
    }

    public Subject() {
    }

    public Subject(Long subjectId, String description, User user) {
        this.subjectId = subjectId;
        this.description = description;
        this.user = user;
    }

    public void setSubjectId(Long subjectId) {

        this.subjectId = subjectId;
    }
    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", description='" + description + '\'' +
                '}';
    }
}
