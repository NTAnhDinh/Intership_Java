package me.learning.javabasic.exercises11_Algorithms;

public class MergeSort {
    private static int[] tempArr;
    private static int[] array = {11, 14, 9, 5};

    public static void main(String[] args) {
        mergeSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int arr[]) {
        int length = arr.length;
        tempArr = new int[length];
        dividePart(0, length - 1);
    }

    private static void dividePart(int fromIdx, int toIdx) {
        if (fromIdx < toIdx) {
            int middle = fromIdx + (toIdx - fromIdx) / 2;
            // sorts the turnLeft side of the array
            dividePart(fromIdx, middle);
            // sorts the turnRight side of the array
            dividePart(middle + 1, toIdx);
            //  merge both sides
            mergePart(fromIdx, middle, toIdx);
        }
    }

    private static void mergePart(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempArr[i] <= tempArr[j]) {
                array[k] = tempArr[i];
                i++;
            } else {
                array[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempArr[i];
            k++;
            i++;
        }
    }
}
