package me.learning.javabasic.exercise7;

import java.util.Scanner;

public class GradesHistogram {
    public static int[] grades;

    public static void main(String[] args) {
        readGrades();
    }

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

    public void printArray(int[] arr) {
        int[] bins = new int[10];

        for (int grade : grades) {

            if (grade == 100) {

                ++bins[9];

            } else {

                ++bins[grade / 10];

            }

        }
        for (int binIdx = 0; binIdx < bins.length; ++binIdx) {


            if (binIdx != 9) {

                System.out.printf("%2d-%3d: ", binIdx * 10, binIdx * 10 + 9);

            } else {

                System.out.printf("%2d-%3d: ", 90, 100);

            }


            for (int itemNo = 0; itemNo < bins[binIdx]; ++itemNo) {

                System.out.print("*");

            }

            System.out.println();

        }
        // Find the max value among the bins

        int binMax = bins[0];

        for (int binIdx = 1; binIdx < bins.length; ++binIdx) {

            if (binMax < bins[binIdx]) binMax = bins[binIdx];

        }
        for (int level = binMax; level > 0; --level) {

            for (int binIdx = 0; binIdx < bins.length; ++binIdx) {

                if (bins[binIdx] >= level) {

                    System.out.print("   *   ");

                } else {

                    System.out.print("       ");

                }

            }

            System.out.println();

        }

        // Print label

        for (int binIdx = 0; binIdx < bins.length; ++binIdx) {

            System.out.printf("%3d-%-3d", binIdx * 10, (binIdx != 9) ? binIdx * 10 + 9 : 100);


        }

        System.out.println();

    }
}
