package me.learning.javabasic.exercise7;

public class ReverseTest {
    public static void main(String agrs[]) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        reverse(array);
    }

    public static void reverse(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;

        }
        PrintArray.printArray(array);
    }
}
