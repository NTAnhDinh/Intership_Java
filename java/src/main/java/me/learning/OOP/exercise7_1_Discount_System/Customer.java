package me.learning.OOP.exercise7_1_Discount_System;

public class Customer {
    private String name;
    private boolean member = false;
    private String memberType;

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public String getMemberType() {
        return memberType;
    }

    public Customer(String name) {

        this.name = name;
    }

    public Customer(String name, boolean member, String memberType) {
        this.name = name;
        this.member = member;
        this.memberType = memberType;
    }

    public Customer() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", member=" + member +
                ", memberType='" + memberType + '\'' +
                '}';
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}
