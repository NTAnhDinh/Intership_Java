package me.learning.javabasic.exercise5;

import java.util.Scanner;

public class Bin2Dec {
    public static void main(String[] args) {
        String binStr;    // The Input binary string
        int binStrLen;    // Length of the input string
        int dec = 0;      // The equivalent decimal number, accumulate from 0
        // Read input into binStr and compute binStrLen
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter binary number : ");
        binStr = sc.next();
        binStrLen=binStr.length();
        // Convert the binary string to decimal, starting from the most-significant digit (turnLeft)
        for (int pos = 0; pos < binStrLen; ++pos) {
            int order = binStrLen - 1 - pos;
            char binChar = binStr.charAt(pos);
            // 3 cases: '1' (add to dec), '0' (do nothing), others (error)
            if (binChar == '1') {
           dec+=(int)Math.pow(2,order);
            } else if (binChar != '0') {
                System.out.println("error: invalid binary string \"" + binStr + "\"");
                System.exit(1);
            }  // else for '0' - do nothing
        }

        // Print result
        System.out.println("The result : " + dec);

        // cach 2
//        int binary ;
//        System.out.println("Enter binary number : ");
//        binary=sc.nextInt(2);
//        System.out.println("The result : " + binary);
    }

}
