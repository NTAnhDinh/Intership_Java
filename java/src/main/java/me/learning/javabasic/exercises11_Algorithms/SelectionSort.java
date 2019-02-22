package me.learning.javabasic.exercises11_Algorithms;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {9, 6, 4, 1, 5};
        int[] arr = selectionSort(array);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index
                }
            }
            int smallNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallNumber;
        }
        return arr;
    }
}
