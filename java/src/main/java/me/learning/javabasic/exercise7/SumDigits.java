package me.learning.javabasic.exercise7;

public class SumDigits {
    public static void main(String[] args) {
        int sum = 0;
        char[] arrChar = args[0].toCharArray();
        System.out.println("The sum of digits = ");
        for (int i = 0; i < arrChar.length - 1; i++) {
            sum += arrChar[i] - '0';
            System.out.print(arrChar[i] + " + ");
        }
        System.out.print(arrChar[arrChar.length - 1] + " = " + sum);
    }
}
