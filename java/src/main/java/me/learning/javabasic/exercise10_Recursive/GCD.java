package me.learning.javabasic.exercise10_Recursive;


import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter number a : ");
        int a = sc.nextInt();
        System.out.print("Enter number b : ");
        int b = sc.nextInt();
        System.out.println(gcd(a, b));
    }
/**
 *
 * @param a
 * @param b
 * @return*/
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, remainder(a, b));
    }

    private static int remainder(int a, int b) {
        return a % b;
    }
}
