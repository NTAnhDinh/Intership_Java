package me.learning.OOP.exercise7_1_Discount_System;

import java.util.Date;

public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
    }

    public Visit(Customer customer, Date date, double serviceExpense, double productExpense) {
        this.customer = customer;
        this.date = date;
        this.serviceExpense = serviceExpense;
        this.productExpense = productExpense;
    }

    public Visit() {
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "customer=" + customer +
                ", date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                '}';
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double result;
        if (customer.isMember()) {
            result = (serviceExpense + productExpense) * 0.1;
        } else {
            if (!customer.isMember()) {
                result = serviceExpense + productExpense;
            } else {
                result = DiscountRate.getProductDisscountRate(customer.getMemberType()) +
                        DiscountRate.getServiceDisscountRate(customer.getMemberType());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DiscountRate discountRate = new DiscountRate();
        Customer c = new Customer("Nguyen Van A", false, "Silver");
        Visit visit = new Visit(c, new Date(2018, 12, 4),
                20000, 24000);
        System.out.println(visit.getTotalExpense());
    }
}
