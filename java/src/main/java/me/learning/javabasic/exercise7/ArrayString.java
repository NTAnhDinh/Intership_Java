package me.learning.javabasic.exercise7;

public class ArrayString {
    public static void main(String agrs[]) {
        int[] arr = new int[3];
        int[] arr1 = new int[]{1};
        int[] arr3 = new int[]{1, 2, 3};
        System.out.println(arrayToString(arr3));
    }

    public static String arrayToString(int[] array) {
        String result = "";
        result += "{ ";
        for (int i = 0; i < array.length-1; i++) {
            result += String.valueOf(array[i]) + " ,";
        }
        result += array[array.length - 1] + " }";
        return result;
    }
}
