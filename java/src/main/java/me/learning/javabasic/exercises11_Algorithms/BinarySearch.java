package me.learning.javabasic.exercises11_Algorithms;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {11, 14, 16, 18, 20, 25, 28, 30, 34, 40, 45};
        int key = 1;
        Arrays.sort(array);
        if( binarySearch(array, key))
            System.out.println("Found it");
        else
            System.out.println("Not found it");
    }

    // Return true if key is found in the array in the range of fromIdx (inclusive), toIdx (exclusive)
    /**
     *
     * @param array
     * @param key
     * @return*/
    public static boolean binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == key) return true;
            else if (array[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return false;

    }
}
