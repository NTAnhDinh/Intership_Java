package me.learning.javabasic.exercise7;

import java.util.Scanner;

public class PrintChart {
    public static int[] grades;

    public static void main(String agrs[]) {
        readInput();
        printChart(grades);
    }

    public static void readInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of bars: ");
        int n = sc.nextInt();
        grades= new int[n];
        int a;
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter bar " + i + " value: ");
             a = sc.nextInt();
            grades[i-1] = a;
        }

    }

    public static void printChart(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
