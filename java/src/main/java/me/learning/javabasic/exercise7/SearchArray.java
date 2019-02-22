package me.learning.javabasic.exercise7;

public class SearchArray {
    public static void main(String agrs[]) {
        int[] array = new int[]{1, 2, 3, 4};
        int key = 0;
        System.out.println(search(array, key));
    }

    public static int search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
