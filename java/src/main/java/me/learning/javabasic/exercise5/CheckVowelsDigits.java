package me.learning.javabasic.exercise5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CheckVowelsDigits {

    public int CheckVowelsAndCount(String s) {
        int count = 0;
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            String[] strArr = st.nextToken().toLowerCase().split("");
            for (int i = 0; i < strArr.length; i++) {
                if ("ueoai".contains(strArr[i])) {
                    count++;
                }
            }

        }
        return count;
    }

    public int CheckDigitalssAndCount(String s) {
        int count = 0;
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            char[] strArr = st.nextToken().toLowerCase().toCharArray();
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] >= '0' && strArr[i] <= '9') {
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String inStr;        // input String
        int inStrLen = 0;        // length of the input String

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a String: ");
        inStr = in.nextLine();
        StringTokenizer st = new StringTokenizer(inStr);
        while (st.hasMoreTokens()) {
            inStrLen += st.nextToken().length();
        }
        CheckVowelsDigits cd = new CheckVowelsDigits();

        System.out.printf("%s %d (%.2f%%) \n", "Number of vowels: ", cd.CheckVowelsAndCount(inStr),
                ((double) cd.CheckVowelsAndCount(inStr) / inStrLen) * 100);
        System.out.printf("%s %d (%.2f%%)", "Number of digits: ", cd.CheckDigitalssAndCount(inStr),
                ((double) cd.CheckDigitalssAndCount(inStr) / inStrLen) * 100);

    }


}
