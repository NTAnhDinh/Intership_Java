package me.learning.OOP.exercise7_1_Discount_System;

/**
 * Co 3 loai thanh vien:
 * 10% cho Silver, 15% cho Gold, 20% cho Premium tuong ung cho cac dich vu duoc cung cap
 * 10% cho thanh vien voi cac san pham duoc cc
 * tinh tong hoa don  cho khach hang mua y dich vu va x san pham cho mot lan truy cap
 */
public class DiscountRate {
    private static double serviceDisscountPremium = 0.2;
    private static double serviceDisscountGold = 0.15;
    private static double serviceDisscountSliver = 0.1;
    private static double productDisscountPremium = 0.1;
    private static double productDisscountGold = 0.1;
    private static double productDisscountSliver = 0.1;

    private enum typeMem {
        Silver, Gold, Premium;
    }

    public static double getServiceDisscountRate(String type) {
        double totalMoney = 0;

        if (type.equals(typeMem.Gold)) {
            totalMoney = serviceDisscountGold;
        }
        if (type.equals(typeMem.Premium)) {
            totalMoney = serviceDisscountPremium;
        }
        if (type.equals(typeMem.Silver)) {
            totalMoney = serviceDisscountSliver;
        }
        return totalMoney;
    }

    public static double getProductDisscountRate(String type) {
        double totalMoney = 0;
        if (type.equals(typeMem.Gold)) {
            totalMoney = productDisscountGold;
        }
        if (type.equals(typeMem.Premium)) {
            totalMoney = productDisscountPremium;
        }
        if (type.equals(typeMem.Silver)) {
            totalMoney = productDisscountSliver;
        }
        return totalMoney;
    }


}
