package me.learning.javabasic.exercise7;

public class ContainArray {
    public static void main(String agrs[]) {
        int[] array = new int[]{1, 2, 3, 4};
        int key = 0;
        System.out.println(contains(array, key));
    }

    public static boolean contains(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }
}
