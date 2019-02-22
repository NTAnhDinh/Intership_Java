package me.learning.javabasic.exercise7;

public class PrintArray {
    public static void main(String agrs[]) {
        int[] arr = new int[]{9, 8, 0};
        double[] arrD = new double[]{1.0, 1.2, 1.56};
        float[] arrF = new float[3];
        printArray(arr);
        printArray(arrD);
        printArray(arrF);

    }

    public static void printArray(int[] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ,");
        }
        System.out.println(array[array.length - 1] + " }");
    }

    public static void printArray(double[] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ,");
        }
        System.out.println(array[array.length - 1] + " }");
    }

    public static void printArray(float[] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ,");
        }
        System.out.println(array[array.length - 1] + " }");
    }
}
