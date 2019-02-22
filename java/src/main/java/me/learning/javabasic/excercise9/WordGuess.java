package me.learning.javabasic.excercise9;

import java.util.Scanner;

public class WordGuess {
    public static String words = "anhdinh";
    public static char[] arrayGuess = new char[words.length()];

    public static void main(String[] args) {
        WordGuess w = new WordGuess();
        System.out.println("java WordGuess testing");


        w.guessWord(words);

    }

    public static void guessWord(String word) {
        char[] words = word.toCharArray();
        boolean[] arrBo = new boolean[words.length];

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        System.out.println("Key in one character or your guess word:  " + line);
        boolean isFlag = true;
        int count = 0;
        for (int i = 0; i < arrayGuess.length; i++) {
            arrayGuess[i] = '_';
        }
        while (isFlag) {
            if (line.length() > 1 || line.length() <= 0) {
                System.out.println("you must be enter a single character");
            } else {
                for (int i = 0; i < words.length; i++) {
                    if (words[i] == line.toLowerCase().charAt(0)) {
                        arrBo[i] = true;
                        arrayGuess[i] = words[i];
                        count++;
                        isFlag = true;

                    }
                    if (count == words.length) {
                        isFlag = false;
                        System.out.println("Key in one character or your guess word:  " + word);
                        System.out.println("Congratulation!\n You got in 4 trials");
                        break;
                    }

                }
                if (!isFlag) break;
                System.out.println("Trial : ");
                printArray(arrayGuess);
                System.out.println("");
            }
            line = sc.nextLine().trim();
            System.out.println("Key in one character or your guess word:  " + line);
        }
    }

    public static void printArray(char[] words) {
        for (char c : words) {
            System.out.print(c);
        }
    }
}
