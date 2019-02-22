package me.learning.javabasic.exercise2_2.extractdigits;

public class ExtractDigits {
    public static void main(String[] args) {
        int n = 123456;
        while (n > 0) {
            int digit = n % 10;
            System.out.print(digit+" ");
            n = n / 10;
        }
//        System.out.println(n%10 +" "+ n/10);
    }
}
