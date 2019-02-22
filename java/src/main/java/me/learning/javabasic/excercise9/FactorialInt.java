package me.learning.javabasic.excercise9;

public class FactorialInt {
    public static void main(String[] args) {
        FactorialInt f = new FactorialInt();
        // print list factorial integer
        f.printListFactorialInt();
        // print list factorial long
        System.out.println("-----------------------");
        f.printListFactorialLong();
    }

    public void printListFactorialInt() {
        // n! = 1*2*3...*n

        int factorial = 1;
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            factorial = factorial * i;
            System.out.println("The factorial of " + i + " is : " + factorial);
            if ((Integer.MAX_VALUE / factorial) < (i + 1)) {
                i++;
                System.out.println("The factorial of " + i + " is out of range ");
                break;
            }

        }
    }

    public void printListFactorialLong() {
        long factorial = 1;
        for (int i = 1; i <= Long.MAX_VALUE; i++) {
            factorial = factorial * i;
            System.out.println("The factorial of " + i + " is : " + factorial);
            if ((Long.MAX_VALUE / factorial) < (i + 1)) {
                i++;
                System.out.println("The factorial of " + i + " is out of range ");
                break;
            }

        }
    }
}
