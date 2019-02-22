package me.learning.javabasic.exercise2_1.printnumberinword;

public class PrintNumberInWord {
    public static void main(String[] args) {
        int number = 5;

        // Using nested-if
        System.out.println("Use nested-if : ");

            if (number == 1) {
                System.out.println("ONE");
            } else if (number == 2) {
                System.out.println("TWO");
            } else if (number == 3) {
                System.out.println("THREE");
            } else if (number == 4) {
                System.out.println("FOUR");
            } else if (number == 5) {
                System.out.println("FIVE");
            } else if (number == 6) {
                System.out.println("SIX");
            } else if (number == 7) {
                System.out.println("SEVEN");
            } else if (number == 8) {
                System.out.println("eight");
            }
            else if (number == 9) {
                System.out.println("NIGHT");
            }else {
                System.out.println("Out of range");
            }


        // Using switch-case
        System.out.println("Use switch-case : ");
        switch (number) {
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("NIGHT");
                break;


            default:
                System.out.println( "Out of range");
        }
    }

}
