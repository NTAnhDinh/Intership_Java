package me.learning.javabasic.exercise7;

public class Swap2Array {
    public static void main(String agrs[]) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2 = {5, 6, 7, 8, 8, 9, 0};
        System.out.println(swap(array1, array2));
    }

    public static boolean swap(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        } else {
            int temp;
            for (int i = 0; i < array1.length; i++) {
                temp = array1[i];
                array1[i] = array2[i];
                array2[i] = temp;
            }
        }
        PrintArray.printArray(array1);
        PrintArray.printArray(array2);
        return true;
    }
}
