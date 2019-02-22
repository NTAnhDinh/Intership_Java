package me.learning.javabasic.exercise2_2.sumandaverage;

public class SumAndAverage {
    public static void main(String[] args) {
        int sum = 0;          // Store the accumulated sum, init to 0
        double average = 0;       // average in double
        int lowerbound = 0;   // The lowerbound to sum
        int upperbound = 100; // The upperbound to sum

        // Use a for-loop to sum from lowerbound to upperbound
        System.out.println("The sum and average by using for : ");
        sumAndAverageByFor(sum, average, lowerbound, upperbound);

        System.out.println("The sum and average by using While : ");
        sumAndAverageByWhile(sum, average, lowerbound, upperbound);

        System.out.println("The sum and average by using While-Do : ");
        sumAndAverageByWhileDo(sum, average, lowerbound, upperbound);

        System.out.println("The sum and average sum only the odd numbers : ");
        sumAndAverageOfOddNumbers(sum, average, lowerbound, upperbound);

        System.out.println("The sum and average sum those numbers from 1 to 100 that is divisible by 7 : ");
        sumAndAverageMultipleOfSeven(sum, average, lowerbound, upperbound);

        System.out.println("The sum of the squares : ");
        sumOfTheSquares(sum, lowerbound, upperbound);
    }

    public static void sumAndAverageByFor(int sum, double average, int lowerbound, int upperbound) {
        for (int number = lowerbound; number <= upperbound; ++number) {
            sum += number;     // same as "sum = sum + number"
        }
        // Compute average in double. Beware that int/int produces int.
        average = (double) sum / (upperbound - lowerbound + 1);
        // Print sum and average.
        System.out.println("The sum is : " + sum);
        System.out.println("The average is : " + average);
    }

    public static void sumAndAverageByWhile(int sum, double aver, int lowerbound, int upperbound) {
        int number = lowerbound;
        while (number <= upperbound) {
            sum += number;
            ++number;
        }
        aver = (double) sum / (upperbound - lowerbound + 1);
        System.out.println("The sum is : " + sum + " ");
        System.out.println("The average is : " + aver);
    }

    public static void sumAndAverageByWhileDo(int sum, double aver, int lowerbound, int upperbound) {
        int number = lowerbound;
        do {
            sum += number;
            ++number;
        } while (number <= upperbound);

        aver = (double) sum / (upperbound - lowerbound + 1);
        System.out.println("The sum is : " + sum);
        System.out.println("The average is : " + aver);
    }

    public static void sumAndAverageOfOddNumbers(int sum, double aver, int lowerbound, int upperbound) {
        for (int i = lowerbound; i <= upperbound; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        aver = (double) sum / (upperbound - lowerbound + 1);
        System.out.println("The sum is : " + sum);
        System.out.println("The average is : " + aver);
    }

    public static void sumAndAverageMultipleOfSeven(int sum, double aver, int lowerbound, int upperbound) {
        for (int i = lowerbound; i <= upperbound; i++) {
            if (i % 7 == 0) {
                sum += i;
            }
        }
        aver = (double) sum / (upperbound - lowerbound + 1);
        System.out.println("The sum is : " + sum);
        System.out.println("The average is : " + aver);
    }

    public static void sumOfTheSquares(int sum, int lowerbound, int upperbound) {
        for (int i = lowerbound; i <= upperbound; i++) {
            sum += i * i;
        }
        System.out.println("The sum is : " + sum);
    }
}
