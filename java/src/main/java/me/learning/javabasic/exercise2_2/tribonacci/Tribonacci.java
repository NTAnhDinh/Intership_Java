package me.learning.javabasic.exercise2_2.tribonacci;

public class Tribonacci {
    public static void main(String[] agrs) {
        printTribonacci(10);
    }

    public static void printTribonacci(int numberMax) {
        int fn , f1 = 1, f2 = 1, f3 = 2;
        for (int i = 1; i <= numberMax; i++) {
            System.out.print(f1 + " ");
            fn = f1 + f2 + f3;
            f1=f2;
            f2=f3;
            f3=fn;
        }
    }
}
