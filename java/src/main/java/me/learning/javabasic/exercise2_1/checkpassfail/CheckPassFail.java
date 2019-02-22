package me.learning.javabasic.exercise2_1.checkpassfail;
/*
* program called CheckPassFail which prints "PASS" if the int variable "mark"
* is more than or equal to 50; or prints "FAIL" otherwise.
* always print “DONE” before exiting.*/
public class CheckPassFail {
    public static void main(String[] args) {  // Program entry point
        int mark = 49;  // Set the value of "mark" here!
        System.out.println("The mark is " + mark);

        if (mark >= 50) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("DONE");
    }

}
