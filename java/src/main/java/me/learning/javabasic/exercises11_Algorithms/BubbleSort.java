package me.learning.javabasic.exercises11_Algorithms;

public class BubbleSort {


    public static void main(String[] args)
    {
        int[] array = {9, 2, 4, 1, 5};
        bubbleSort(array);
    }
/**
 *tra ve mang da sap xep
 * @param array*/
    public static void bubbleSort(int[] array) {
        int n = array.length;
        int temp = 0;
        boolean swapped;  /* boolean flag to indicate swapping occurred during a pass */
        do {

            swapped = false; /* reset for each pass */

            for (int j = 1; j <= n - 1; j++) {
                /* if this pair is out of order */
                if (array[j - 1] > array[j]) {
                    /* swap them and take note something changed */
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                }
                swapped = true;
            }

            n = n - 1; /* One item sorted after each pass */
        }
        while (swapped);  /* repeat another pass if swapping occurred */
        printArray(array);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
