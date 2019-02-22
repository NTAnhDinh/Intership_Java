package me.learning.javabasic.exercise12;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectAndDeficientNumbers {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(n + " is perfect number ? " + isPerfect(n));
//        System.out.println(n + " is deficien number ? : " + isDeficien(n));
        perfectNumberList();
    }
/**
 *return true  khi tong cua cac nhan to cua postInt bang voi chinh no
 * @param posInt
 * @return*/
    public static boolean isPerfect(int posInt) {
        int sum = 0;
        for (int i = 1; i < posInt; i++) {
            sum += (posInt % i == 0 ? i : 0);
        }
        return sum == posInt;
    }
/**
 *return true when  the sum of all n proper divisors is less than  value n
 * @param n
 * @return*/
    public static boolean isDeficien(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += (n % i == 0 ? i : 0);
        }

        return sum < n;
    }
/**
 * the program  prompts user for an upper bound (a positive integer),
 * and lists all the perfect numbers less than or equal to this upper bound
 */

    public static void perfectNumberList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the upper bound: ");
        int upperBound = sc.nextInt();// prompts user for an upper bound
        ArrayList<Integer> listPerfect = new ArrayList<>();
        for (int i = 1; i <= upperBound; i++) {
            if (isPerfect(i)) {
                listPerfect.add(i);// if is isPerfect then add it in listPerfect
            }
        }
        System.out.println("These numbers are perfect: ");
        for (int i : listPerfect) {
            System.out.print(i + " ");// print listPerfect
        }
        int len = listPerfect.size();
        double phantram = (double)(len *100)/upperBound;
        System.out.println("\n [ " + len + " perfect numbers found (" + phantram + "%)]");
    }
}
