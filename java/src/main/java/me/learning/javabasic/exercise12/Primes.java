package me.learning.javabasic.exercise12;

import java.util.ArrayList;
import java.util.Scanner;

public class Primes {
    public static void main(String[] args) {
//        System.out.println(isPrime(9973));
        primeList();
    }
/**
 *returns true if the number is a prime.
 * @param posInt
 * @return*/
    public static boolean isPrime(int posInt) {
        if (posInt == 0) return false;
        for (int i = 2; i < posInt; i++) {
            if (posInt % i == 0) return false;
        }
        return true;
    }
/**
 * */
    public static void primeList() {
        Scanner sc = new Scanner(System.in);
        int bound = sc.nextInt();
        ArrayList<Integer> listPrime = new ArrayList<>();
        for (int i = 1; i <= bound; i++) {
            if (isPrime(i)) {
                listPrime.add(i);
            }
        }
        System.out.print("Please enter the upper bound:  ");
        for (int i : listPrime) {
            System.out.print(i + " ");
        }
        System.out.print(" [" + listPrime.size() + " primes found (" + (double) (listPrime.size() * 100) / bound + "% )]");
    }
}
