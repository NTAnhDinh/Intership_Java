package me.learning.javabasic.exercise7;

public class CompareArray {
    public static void main(String agrs[]) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2};
        System.out.println("Hai mang co bang nhau khong? " + equals(array1, array2));
    }

    public static boolean equals(int[] array1, int[] array2) {
        boolean isEqual = true;
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    isEqual = false;
                }
            }
        } else {
            isEqual = false;
        }
        return isEqual;
    }
}
