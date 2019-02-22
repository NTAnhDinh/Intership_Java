package me.learning.javabasic.exercise6;

import java.util.Scanner;

public class GradesAverage {
    public void gradesAverage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students : ");
        int numberStudents = sc.nextInt();
        int[] grades;
        int sum = 0;

        grades = new int[numberStudents];
        for (int i = 1; i <= grades.length; i++) {

            System.out.println("Enter the grade for student " + i);
            int grade = sc.nextInt();
            if (grade <= 100 && grade >= 0) {
                grades[i - 1] = grade;
                sum += grade;
            } else {
                i = i - 1;
                System.out.println("Invalid grade, try again...");
            }
        }
        System.out.println("The average is: " + (double) sum / numberStudents);
    }

    public static void main(String agrs[]) {
        GradesAverage ga = new GradesAverage();
        ga.gradesAverage();
    }
}
