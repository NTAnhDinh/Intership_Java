package me.learning.javabasic.exercise7;

public class CopyArray {
    public static void main(String agrs[]) {
        int[] array = {1, 2, 3, 4};
        int[] arr = copyOf(array);
        PrintArray.printArray(arr);
        int[] re = copyOf(array, 2);
        PrintArray.printArray(re);

    }

    public static int[] copyOf(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static int[] copyOf(int[] array, int newLength) {
        int[] result = new int[newLength];
        if (newLength == array.length) {
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
        } else {
            if (newLength < array.length) {
                for (int i = 0; i < newLength; i++) {
                    result[i] = array[i];
                }
            } else {
                for (int i = 0; i < newLength; i++) {
                    try {
                        result[i] = array[i];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        result[i] = 0;
                    }

                }

            }

        }
        return result;
    }
}