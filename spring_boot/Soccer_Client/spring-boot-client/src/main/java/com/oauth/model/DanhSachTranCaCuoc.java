package com.oauth.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity
@Table(name = "ds_trancacuoc")
public class DanhSachTranCaCuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trandau_id")
    int trandau_id;
    @Column(name = "ten_trandau")
    String ten_trandau;
    @JsonIgnore
    @OneToMany(mappedBy = "ds_cacuoc", cascade = CascadeType.ALL)
    List<TiSo> list_ts;
    //	 int remain_fund;
//	 int percent_BetFund;
    public DanhSachTranCaCuoc() {
    }
    public DanhSachTranCaCuoc(int trandau_id, String ten_trandau) {
        super();
        this.trandau_id = trandau_id;
        this.ten_trandau = ten_trandau;
//		this.remain_fund=100000;
//		this.percent_BetFund=15;
    }

    //	public int getRemain_fund() {
//		return remain_fund;
//	}
//	public int getPercent_BetFund() {
//		return percent_BetFund;
//	}
    public int getTrandau_id() {
        return trandau_id;
    }

    public void setTrandau_id(int trandau_id) {
        this.trandau_id = trandau_id;
    }

    public String getTen_trandau() {
        return ten_trandau;
    }

    public void setTen_trandau(String ten_trandau) {
        this.ten_trandau = ten_trandau;
    }

    public List<TiSo> getList_ts() {
        return list_ts;
    }

    public void setList_ts(List<TiSo> list_ts) {
        this.list_ts = list_ts;
    }

    @Override
    public String toString() {
        return "DanhSachTranCaCuoc{" +
                "trandau_id=" + trandau_id +
                ", ten_trandau='" + ten_trandau + '\'' +
                ", list_ts=" + list_ts +
                '}';
    }
}
