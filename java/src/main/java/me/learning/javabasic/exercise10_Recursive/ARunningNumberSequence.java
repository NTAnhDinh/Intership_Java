package me.learning.javabasic.exercise10_Recursive;

import java.util.Scanner;

public class ARunningNumberSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data : ");
        int n = sc.nextInt();
        System.out.println(S(n));
    }

    /**
     * compute the length of S(n).
     * ex: S(9) = 123456789       // length is 9
     *
     * @param n
     * @return
     */
    public static int S(int n) {
        if (n > 0) {
            if (n == 1) return 1;
            return S(n - 1) + String.valueOf(n).length();
        } else {
            return 0;
        }
    }
}
