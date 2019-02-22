package me.learning.javabasic.exercise12;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
//        System.out.println(isProductOfPrimeFactors(30));
        perfectPrimeFactorList();
    }

    /**
     * return true if the  all  prime factors of posInt(excluding 1 and the number itself)
     * is equal to value posInt
     *
     * @param posInt
     * @return
     */
    public static boolean isProductOfPrimeFactors(int posInt) {
        int tich = 1;
        int p = posInt;
        for (int i = 2; i < posInt; i++) {
            if (Primes.isPrime(i) && posInt % i == 0) {
                tich = tich * i;
                p = p / i;
            }
        }
        return tich == posInt;
    }

    /**
     * return list number equal to product of prime factors
     */
    public static void perfectPrimeFactorList() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the upper bound: ");
        int bound = sc.nextInt();
        ArrayList<Integer> listPrime = new ArrayList<>();
        for (int i = 1; i <= bound; i++) {
            if (isProductOfPrimeFactors(i)) {
                listPrime.add(i);
            }
            System.out.print(" These numbers are equal to the product of prime factors:");
            for (int n : listPrime) {
                System.out.print(n + " ");
            }
            System.out.print(" [" + listPrime.size() + " numbers found (" + (double) (listPrime.size() * 100) / bound + ")]");

        }
    }
}
