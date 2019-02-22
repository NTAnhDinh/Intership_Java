package me.learning.javabasic.exercise5;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        String inStr;        // input String
        int inStrLen;        // length of the input String

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a String: ");
        inStr = in.nextLine();   // use next() to read a String
        inStrLen = inStr.length();
        System.out.print("The result is : ");
        for (int i = inStrLen - 1; i >= 0; --i) {  // Process the String from the turnRight
        System.out.print(inStr.charAt(i));
        }
    }

}
