package me.learning.javabasic.exercises11_Algorithms;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10, 14, 19, 26, 27, 31, 33, 35, 42, 44};
        int key = 3;
        if(linearSearch(arr, key))
        System.out.println("Found it");
        else
            System.out.println("Not found it");
    }

    public static boolean linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) return true;
        }
        return false;
    }
}
