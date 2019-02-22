package me.learning.javabasic.exercise7;

import java.util.Scanner;

public class OddTest {
    public static void main(String agrs[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data input : ");
        int number = sc.nextInt();
        if (isOdd(number)) {
            System.out.println("ODD ");
        } else {
            System.out.println("EVEN ");
        }
    }

    public static boolean isOdd(int number) {
        if (number < 0 || number == 0 || number % 2 == 0)
            return false;
        return true;
    }

}
