package me.learning.javabasic.exercise2_1.checkoddeven;

/*
 * Write a program called CheckOddEven which prints "Odd Number" if the int variable “number” is odd,
 * or “Even Number” otherwise. The program shall always print “BYE!” before exiting.*/
public class CheckOddEven {
    public static void main(String[] args) {  // Program entry point
        int number = -1;       // Set the value of "number" here!
        System.out.println("The number is " + number);
        if (number == 0 || number < 0) System.out.println("Not valid");
        else {
            if (number % 2 != 0) {
                System.out.println("Odd Number");
            } else {
                System.out.println("Even Number");
            }
        }
        System.out.println("BYE!");
    }

}
