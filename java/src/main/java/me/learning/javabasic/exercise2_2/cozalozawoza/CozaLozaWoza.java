package me.learning.javabasic.exercise2_2.cozalozawoza;

public class CozaLozaWoza {
    public static void main(String[] args) {
        int lowerbound = 1, upperbound = 110;
        for (int number = lowerbound; number <= upperbound; ++number) {
            // Print "Coza" if number is divisible by 3
            if ( number%3==0 ) {
                System.out.print("Coza");
            }
            // Print "Loza" if number is divisible by 5
            if (number%5==0) {
                System.out.print("Loza");
            }
            // Print "Woza" if number is divisible by 7
            if (number%7==0) {
                System.out.print("Woza");
            }
            // Print the number if it is not divisible by 3, 5 and 7 (i.e., it has not been processed above)
            if (number%7!=0 && number%5!=0 && number%3!=0) {
                System.out.print(number);

            }
            // After processing the number, print a newline if number is divisible by 11;
            // else print a space
            if ( number%11==0) {
                System.out.println();  // print newline
            } else {
                System.out.print( " " );  // print a space
            }
        }
    }

}
