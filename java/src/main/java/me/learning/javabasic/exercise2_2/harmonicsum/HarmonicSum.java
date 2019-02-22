package me.learning.javabasic.exercise2_2.harmonicsum;

public class HarmonicSum {
    public static void main(String[] args) {
        int maxDenominator = 50000;  // Use a more meaningful name instead of n
        double sumL2R = 0.0;    // sum from turnLeft-to-turnRight
        double sumR2L = 0.0;    // sum from turnRight-to-turnLeft

        // for-loop for summing from turnLeft-to-turnRight
        for (int denominator = 1; denominator <= maxDenominator; ++denominator) {
            sumL2R += (double) 1 / denominator;
            sumR2L += (double) 1 / (maxDenominator - denominator + 1);
        }

        System.out.println("The sum from turnLeft-to-turnRight is: " + sumL2R);
        System.out.println("The sum from turnRight-to-turnLeft is: " + sumR2L);


    }
}
