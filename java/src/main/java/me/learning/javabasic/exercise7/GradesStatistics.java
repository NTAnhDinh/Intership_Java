package me.learning.javabasic.exercise7;

import java.util.Arrays;
import java.util.Scanner;

public class GradesStatistics {
    public static int[] grades;

    public static void main(String[] args) {
        readGrades();  // Read and save the inputs in int[] grades
        printArray(grades);
        System.out.println("The average is " + average(grades));
        System.out.println("The median is " + median(grades));
        System.out.println("The minimum is " + min(grades));
        System.out.println("The maximum is " + max(grades));
        System.out.println("The standard deviation is " + stdDev(grades));
    }

    // Prompt user for the number of students and allocate the global "grades" array.
    // Then, prompt user for grade, check for valid grade, and store in "grades".
    public static void readGrades() {

        System.out.println("Enter the number of students: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        grades = new int[number];
        for (int i = 1; i <= number; i++) {
            System.out.println("Enter the grade for student " + i + " :");
            int value = sc.nextInt();
            if (value <= 100 && value >= 0) {
                grades[i - 1] = value;
            }
        }
    }

    // Print the given int array in the form of {x1, x2, x3,..., xn}.
    public static void printArray(int[] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ,");
        }
        System.out.println(array[array.length - 1] + " }");
    }

    // Return the average value of the given int[]
    public static double average(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / array.length;
    }

    // Return the median value of the given int[]
    // Median is the center element for odd-number array,
    // or average of the two center elements for even-number array.
    // Use Arrays.sort(anArray) to sort anArray in place.
    public static double median(int[] array) {
        double median = 0;
        Arrays.sort(array);
        if (array.length % 2 != 0) {
            median = array[array.length / 2];
        }
        if (array.length % 2 == 0) {
            median = (double) (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        }
        return median;
    }

    // Return the maximum value of the given int[]
    public static int max(int[] array) {
        int max = array[0];   // Assume that max is the first element
        // From second element, if the element is more than max, set the max to this element.
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Return the minimum value of the given int[]
    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Return the standard deviation of the given int[]
    public static double stdDev(int[] array) {
        double stdDev = 0;
        double hieu = 0;
        for (int i = 0; i < array.length; i++) {
            hieu += Math.pow(array[i], 2) - Math.pow(average(array), 2);
        }
        int length =array.length;
        stdDev = (Math.sqrt(((double)1/length)*hieu));
        return stdDev;
    }

}
