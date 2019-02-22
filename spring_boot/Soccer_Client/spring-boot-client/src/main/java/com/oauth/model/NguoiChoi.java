package com.oauth.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity

@Table(name = "nguoichoi")
public class NguoiChoi implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "balance")
    int tongThu;
    @Column(name="role")
    String role;

    @ManyToMany
    @JoinTable(name = "danhsach_nguoichoi", joinColumns = @JoinColumn(name = "nguoichoi_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tiso_id", referencedColumnName = "tiso_id"))
    private List<TiSo> listTiSo;



    public NguoiChoi(int id, String ten, String username, String password, int tongThu, String role
    ) {
        super();
        this.id = id;
        this.ten = ten;
        this.username = username;
        this.password = password;
        this.tongThu = tongThu;
        this.role = role;

    }

    public NguoiChoi(int id, String ten, String username, String password, int tongThu, String role,
                     List<TiSo> listTiSo) {
        super();
        this.id = id;
        this.ten = ten;
        this.username = username;
        this.password = password;
        this.tongThu = tongThu;
        this.role = role;
        this.listTiSo = listTiSo;
    }

    public NguoiChoi() {
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public int getTongThu() {
        return tongThu;
    }

    public void setTongThu(int tongThu) {
        this.tongThu = tongThu;
    }


    public List<TiSo> getListTiSo() {
        return listTiSo;
    }

    public void setListTiSo(List<TiSo> listTiSo) {
        this.listTiSo = listTiSo;
    }

    @Override
    public String toString() {
        return "NguoiChoi [id=" + id + ", ten=" + ten + ", username=" + username + ", password=" + password
                + ", tongThu=" + tongThu + ", role=" + role +  "]";
    }
}
