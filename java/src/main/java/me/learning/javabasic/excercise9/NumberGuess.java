package me.learning.javabasic.excercise9;

import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        NumberGuess numberGuess = new NumberGuess();


        System.out.println("java NumberGuess");
        int secretNumber = (int) (Math.random() * 100);
        System.out.println(" Key in your guess: " + secretNumber);
        Scanner sc = new Scanner(System.in);
        int score = 0;
        System.out.println("Enter data :");
        int numberUser = sc.nextInt();

        while (score != 4) {
            score = numberGuess.guessNumberProgram(secretNumber, numberUser);
            if (score == 1) {
                System.out.println("Try higher" );
            } else {
                if (score == -1) {
                    System.out.println("Try lower" );
                }
                else{
                    break;
                }
            }
            numberUser = sc.nextInt();
        }
        System.out.println("You got it in " + score + " trials!");
    }


    public int guessNumberProgram(int secretNumber, int numberUser) {
        if (secretNumber < numberUser) {
            return 1;

        } else {
            if (secretNumber > numberUser) return -1;

            else {
                return 4;

            }
        }
    }

}

