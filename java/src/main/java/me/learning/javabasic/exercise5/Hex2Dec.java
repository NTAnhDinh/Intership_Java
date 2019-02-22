package me.learning.javabasic.exercise5;

import java.util.Scanner;

public class Hex2Dec {
    public static void main(String[] args) {
        String hexStr;
        char hexChar;
        int dec = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hexa number : ");
        hexStr = sc.next();
        for (int pos = 0; pos < hexStr.length(); ++pos) {
            hexChar = hexStr.charAt(pos);
            int order = hexStr.length() - 1 - pos;
// 23 cases: '0'-'9', 'a'-'f', 'A'-'F', others (error)
            if (hexChar >= '0' && hexChar <= '9') {
                dec += (hexChar - '0') * Math.pow(16, order);

            } else if (hexChar >= 'a' && hexChar <= 'f') {   // lowercase
                dec +=(hexChar - 'a' + 10)  * Math.pow(16, order);

            } else if (hexChar >= 'A' && hexChar <= 'F') {   // uppercase (use in.next().toLowerCase() to eliminate this)
                dec +=(hexChar - 'A' + 10) * Math.pow(16, order);

            } else {
                System.out.println("error: invalid hexadecimal string");
                System.exit(1);    // quit the program
            }
        }
        // Print result
        System.out.println("The result : " + dec);
    }
}
