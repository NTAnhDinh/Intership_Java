package me.learning.javabasic.exercise10_Recursive;

import java.util.Scanner;

public class TowerofHanoiRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfDiscs = scanner.nextInt();
        move(numOfDiscs, "Pole 1", "Pole 2", "Pole 3");
    }

    public static void move(int n, String start, String auxiliary, String end) {
        if (n == 1) {
            System.out.println(start + " -> " + end);
        } else {
            move(n - 1, start, end, auxiliary);
            System.out.println(start + " -> " + end);
            move(n - 1, auxiliary, start, end);
        }
    }
}
