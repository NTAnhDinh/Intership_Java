package me.learning.javabasic.exercises11_Algorithms;

import java.awt.*;

public class QuickSort {
    private static int[] array = {20, 11, 18, 14, 15, 9, 32, 5, 26};

    public static void main(String[] args) {
        quickSort(array);
        for (int i =0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static boolean quickSort(int[] array) {
        int fromIdx = 0;
        int toIdx = array.length - 1;
        quickSort(fromIdx, toIdx);
        return true;
    }

    private static void quickSort(int fromIdx, int toIdx) {
        int i, j;
        i = fromIdx;
        j = toIdx;
        // calculate pivot number
        int pivot = array[fromIdx + (toIdx - fromIdx) / 2];
        // Divide into two arrays
        while (i <= j) {

            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // use recursive call quickSort() method
        if (fromIdx < j)
            quickSort(fromIdx, j);
        if (i < toIdx)
            quickSort(i, toIdx);
    }

    private static void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
