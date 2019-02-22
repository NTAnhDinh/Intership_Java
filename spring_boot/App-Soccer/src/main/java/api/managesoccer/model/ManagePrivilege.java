package api.managesoccer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "manage_privilege")
public class ManagePrivilege implements Serializable {
    @Id
    @Column(name = "stt")
    int stt;
    @Column(name = "role_id")
    int roleId;

    @Column(name = "path")
    String path;
    @Column(name = "insert")
    int insert;
    @Column(name = "update")
    int update;
    @Column(name = "delete")
    int delete;
    @Column(name = "retrieve")
    int retrieve;

    public ManagePrivilege() {
    }

    public ManagePrivilege(int stt, int roleId, String path, int insert, int update, int delete, int retrieve) {
        this.stt = stt;
        this.roleId = roleId;
        this.path = path;
        this.insert = insert;
        this.update = update;
        this.delete = delete;
        this.retrieve = retrieve;
    }

    public int getStt() {
        return stt;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert = insert;
    }

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public int getRetrieve() {
        return retrieve;
    }

    public void setRetrieve(int retrieve) {
        this.retrieve = retrieve;
    }
}
