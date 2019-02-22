package me.learning.javabasic.exercises11_Algorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 14, 3, 2, 43, 11, 58, 22};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
/**
 *
 * @param array*/
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while ((j >= 0) && (array[j] > key)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
