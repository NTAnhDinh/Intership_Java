package me.learning.javabasic.exercise2_2.Product1ToN;

public class Product1ToN {
    public static void main(String[] args) {
        int startNumber = 1;
        System.out.println("Compute products and store result by int : " );
        computeProductsAndStoreByInt(startNumber, 10);
        computeProductsAndStoreByInt(startNumber, 11);
        computeProductsAndStoreByInt(startNumber, 12);
        computeProductsAndStoreByInt(startNumber, 13);
        computeProductsAndStoreByInt(startNumber, 14);


        System.out.println("Compute products and store result by long : " );
        computeProductsAndStoreByLong(startNumber, 10);
        computeProductsAndStoreByLong(startNumber, 11);
        computeProductsAndStoreByLong(startNumber, 12);
        computeProductsAndStoreByLong(startNumber, 13);
        computeProductsAndStoreByLong(startNumber, 14);
    }

    public static void computeProductsAndStoreByInt(int startNumber, int endNumber) {
        int result = 1;
        for (int i = startNumber; i <= endNumber; i++) {
            result *= i;
        }
        System.out.println("Result of products : " + result);
    }
    public static void computeProductsAndStoreByLong(int startNumber, int endNumber) {
        long result = 1;
        for (int i = startNumber; i <= endNumber; i++) {
            result *= i;
        }
        System.out.println("Result of products : " + result);
    }
}
