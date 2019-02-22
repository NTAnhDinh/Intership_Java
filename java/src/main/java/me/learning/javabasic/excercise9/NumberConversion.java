package me.learning.javabasic.excercise9;

import java.util.Scanner;
import java.util.StringTokenizer;

public class NumberConversion {
    private static final String sequence = "0123456789ABCDEF";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data input : ");
        String in = sc.nextLine();
        System.out.println("Enter data inRadix : ");
        int inRadix = sc.nextInt();
        System.out.println("Enter data outRadix : ");
        int outRadix = sc.nextInt();
        System.out.println(toRadix(in, inRadix, outRadix));
    }

    public static String toRadix(String in, int inRadix, int outRadix) {

        return convertRadix(parseInt(in, inRadix), outRadix);
    }

    /**
     * convert String to int
     *
     * @param in
     * @return
     */
    public static int parseInt(String in, int inRadix) {
        int result = 0;
        for (int i = in.length() - 1; i >= 0; i--) {
            if (in.charAt(i) != ' ') {
                int number = Character.digit(in.charAt(i), inRadix);
                result += number * Math.pow(inRadix, in.length() - i - 1);
            }
        }
        return result;
    }

    /**
     * @param in
     * @param outRadix
     * @return
     */
    public static String convertRadix(int in, int outRadix) {
        String result = "";
        if (outRadix > 0 && in > 0) {
            while (in > 0) {
                int remainer = in % outRadix;
                result += sequence.charAt(remainer);
                in /= outRadix;
            }
        } else {
            return "Error";
        }
        String temp = " ";
        for (int i = result.length() - 1; i >= 0; i--) {
            temp += result.charAt(i);
        }
        return temp;
    }

}
