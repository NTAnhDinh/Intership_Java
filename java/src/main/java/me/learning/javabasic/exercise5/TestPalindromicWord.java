package me.learning.javabasic.exercise5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TestPalindromicWord {
    public static void main(String[] args) {
        String inStr;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter data :");
        inStr = in.nextLine();
        StringTokenizer st = new StringTokenizer(inStr, "//");
        String delimiter = "";
        String s = "";
        s = st.nextToken();
        delimiter = st.nextToken();
        TestPalindromicWord testPalindromicWord = new TestPalindromicWord();
        System.out.println(testPalindromicWord.testPalindromivWord(s.toLowerCase(), delimiter));
    }

    public boolean testPalindromivWord(String sequen, String delim) {
        StringTokenizer st = new StringTokenizer(sequen, delim);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken().replaceAll(" ", ""));
        }
        System.out.println(sb);
        int strLen = sb.length();
        int fIdx = 0, bIdx = strLen - 1;
        boolean isPalindromi = false;
        while (fIdx < bIdx) {
            if (sb.charAt(fIdx) != sb.charAt(bIdx)) {
                isPalindromi = false;
            } else {
                isPalindromi = true;
            }
            fIdx++;
            bIdx--;
        }

        return isPalindromi;
    }
}
