package me.learning.javabasic.exercise7;

import java.util.Scanner;

public class MagicSum {
    public static void main(String agrs[]) {
        MagicSum m = new MagicSum();
        System.out.println("The magic sum is: "+m.magicSum());
    }
    public int magicSum() {
        int number;
        int sentinel = -1;
        Scanner in = new Scanner(System.in);
// Read first input
        System.out.print("Enter a positive integer or -1 to exit: ");
        number = in.nextInt();
        int sum = 0;

        while (number != sentinel) {  // Read until input is -1
            if (NumberEightTest.hasEight(number)) {
                sum += number;
            }
            // Read next input (Take note that you need to repeat these codes!)
            System.out.print("Enter a positive integer or -1 to exit: ");
            number = in.nextInt();
        }
return sum;
    }
}
