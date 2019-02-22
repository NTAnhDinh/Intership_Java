package me.learning.javabasic.exercise6;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Hex2Bin {
    public static void main(String[] args) {
        Hex2Bin hex2Bin = new Hex2Bin();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
       String[] result= hex2Bin.convert(s);
       for(int i=0;i<result.length;i++){
           System.out.print(result[i]+" ");
       }
    }

    public String[] convert(String str) {
        char[] arrStr = str.toCharArray();
        int length = arrStr.length;
        String[] bin = new String[length];
        int dec = 0;

        for (int i = 0; i < length; i++) {
            int count = 0;
            int result;
            String remainer = "";
            if (arrStr[i] >= '0' && arrStr[i] <= '9') {
                result = arrStr[i] - '0';
                while (count < 4) {

                    remainer += result % 2;
                    result = result / 2;
                    count++;
                }
                bin[i] = reverse(remainer);
//                System.out.println("pt " + bin[i]);
            } else if (arrStr[i] >= 'a' && arrStr[i] <= 'f') {   // lowercase
                result = arrStr[i] - 'a' + 10;
                while (count < 4) {

                    remainer += result % 2;
                    result = result / 2;
                    count++;
                }
                bin[i] = reverse(remainer);
//                System.out.println("pt " + bin[i]);

            } else if (arrStr[i] >= 'A' && arrStr[i] <= 'F') {
                result = arrStr[i] - 'A' + 10;
                while (count < 4) {

                    remainer += result % 2;
                    result = result / 2;
                    count++;
                }
                bin[i] = reverse(remainer);
//                System.out.println("pt " + bin[i]);
            } else {
                System.out.println("error: invalid hexadecimal string");
                System.exit(1);    // quit the program
            }
        }
        return bin;
    }

    public String reverse(String s) {
        char[] arrStr = s.toCharArray();
        String result = "";
        for (int i = arrStr.length - 1; i >= 0; i--) {
            result += arrStr[i];
        }
        return result.trim();
    }
}
