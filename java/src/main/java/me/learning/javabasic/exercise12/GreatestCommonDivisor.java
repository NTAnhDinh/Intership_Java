package me.learning.javabasic.exercise12;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a, b));
    }
/**
 *GCD(a, 0) = a
 * GCD(a, b) = GCD(b, a mod b), where (a mod b) denotes the remainder of a divides by b.
 * @param a :
 * @param b
 * @return*/
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        int temp = 0;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return gcd(a, b);
    }
}
