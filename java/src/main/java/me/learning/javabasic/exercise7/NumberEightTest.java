package me.learning.javabasic.exercise7;

import java.util.Scanner;

public class NumberEightTest {
    public static void main(String agrs[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data input : ");
        int number = sc.nextInt();
        if (hasEight(number)) {
            System.out.println("YES ");
        } else {
            System.out.println("NO ");
        }
    }

    public static boolean hasEight(int number) {
        String num = number + " ";
        char[] arr = num.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '8') {
                return true;
            }
        }
        return false;
    }
}
