package me.learning.javabasic.excercise9;

public class FibonacciInt {
    public static void main(String[] args) {
        FibonacciInt f = new FibonacciInt();
        f.printListFibonacci();
    }

    public void printListFibonacci() {
        int fn, f1 = 1, f2 = 1;
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            fn = f1 + f2;
            System.out.println("F(" + i + ") = " + f2 + " ");
            f2 = f1;// f2 la so lien truoc
            f1 = fn;//f1 la so lien sau
            if (Integer.MAX_VALUE - f1 < f2) {
                i++;
                System.out.println("F(" + i + ")" + " out of the range of int");
                break;
            }
        }
    }

    public void printListTribonacci() {

    }
}
