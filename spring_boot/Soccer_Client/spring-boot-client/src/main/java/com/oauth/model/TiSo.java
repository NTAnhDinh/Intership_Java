package com.oauth.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tiso")
public class TiSo implements Serializable {
    @Id
    @Column(name = "tiso_id")
    int tiso_id;
    @Column(name = "tiso_1")
    int tiSo1;
    @Column(name = "tiso_2")
    int tiSo2;
    @Column(name = "ratio")
    double ratio;
    @Column(name = "price")
    int price;
    //    @Column(name = "trandau_id")
//    int trandau_id;
    @JsonBackReference
    @ManyToMany(mappedBy = "listTiSo")
    List<NguoiChoi> listNguoiChoi;
    @ManyToOne
    @JoinColumn(name = "trandau_id")
    DanhSachTranCaCuoc ds_cacuoc;

    public TiSo(int tiso_id, int tiSo1, int tiSo2, double ratio, int price, List<NguoiChoi> listNguoiChoi) {
        this.tiso_id = tiso_id;
        this.tiSo1 = tiSo1;
        this.tiSo2 = tiSo2;
        this.ratio = ratio;
        this.price = price;
//        this.trandau_id = trandau_id;
        this.listNguoiChoi = listNguoiChoi;
    }

    public TiSo() {
    }

    public int getTiso_id() {
        return tiso_id;
    }

    public void setTiso_id(int tiso_id) {
        this.tiso_id = tiso_id;
    }

    public int getTiSo1() {
        return tiSo1;
    }

    public void setTiSo1(int tiSo1) {
        this.tiSo1 = tiSo1;
    }

    public int getTiSo2() {
        return tiSo2;
    }

    public void setTiSo2(int tiSo2) {
        this.tiSo2 = tiSo2;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<NguoiChoi> getListNguoiChoi() {
        return listNguoiChoi;
    }

    public void setListNguoiChoi(List<NguoiChoi> listNguoiChoi) {
        this.listNguoiChoi = listNguoiChoi;
    }

    public DanhSachTranCaCuoc getDs_cacuoc() {
        return ds_cacuoc;
    }

    @Override
    public String toString() {
        return "TiSo{" +
                "tiso_id=" + tiso_id +
                ", tiSo1=" + tiSo1 +
                ", tiSo2=" + tiSo2 +
                ", ratio=" + ratio +
                ", price=" + price +
                ", listNguoiChoi=" + listNguoiChoi +
                ", ds_cacuoc=" + ds_cacuoc +
                '}';
    }
}
