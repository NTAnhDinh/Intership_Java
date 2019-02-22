package me.learning.javabasic.exercise2_2.fibonacci;

public class Fibonacci {
    public static void main(String[] args) {

        displayandAverageOfFibonaccis();
    }

    public static double displayandAverageOfFibonaccis() {
        int n = 1;
        int fn, f1 = 1, f2 = 1;
        int numberMax = 20;
        int sum = f1 + f2;
        System.out.println("The first " + numberMax + " Fibonacci numbers are:");
        while (n <= numberMax) {
            fn = f1 + f2;
            sum += fn;
            System.out.print(f2 + " ");
            f2 = f1;
            f1 = fn;
            n++;
        }
        // Compute and display the average (=sum/nMax).

        return (double) sum / numberMax;

    }
}
