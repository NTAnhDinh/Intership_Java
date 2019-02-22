package me.learning.javabasic.exercise10_Recursive;

import me.learning.javabasic.exercise3.Factorial;

import java.util.Scanner;

public class FactorialRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data : ");
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
