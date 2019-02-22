package me.learning.javabasic.exercise10_Recursive;

public class FibonacciRecursive {
    public static void main(String[] args) {
        int n=20;
        System.out.println("The Fibonacci number of number  "+ n);
        System.out.println(fibonacci(n));

    }

    public static int fibonacci(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
