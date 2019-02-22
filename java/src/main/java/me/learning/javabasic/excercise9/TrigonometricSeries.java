package me.learning.javabasic.excercise9;

public class TrigonometricSeries {
    public static void main(String[] args) {
        TrigonometricSeries tri = new TrigonometricSeries();
        double x = 30;
        int numTerms = 10;
        System.out.println("sin of " + x + " : " + tri.sin(x, numTerms));

        System.out.println("cos of " + x + " : " + tri.cos(x, numTerms));


        System.out.println("java.lang.Math values:");

        System.out.println("sin of " + x + " : " + Math.sin((Math.PI) * x / 180));

        System.out.println("cos of " + x + " : " + Math.cos((Math.PI) * x / 180));
        System.out.println(" Compute e and exp(x) :");
        System.out.println(tri.exp(numTerms));
        System.out.println(tri.exp((Math.PI) * x / 180, numTerms));
    }

    public double tinhGioiHan(double x, int numTerms) {
        double term = 1.0;
        for (int i = numTerms; i > 0; i--) {
            term *= x / i;
        }

        return term;
    }

    public double sin(double x, int numTerms)

    {

        x = (Math.PI) * x / 180;

        double result = 0;

        for (int i = 0; i < numTerms; i++) {

            result += (i % 2 == 0 ? 1 : -1) * tinhGioiHan(x, (2 * i + 1));

        }

        return result;

    }


    public double cos(double x, int numTerms) {
        x = (Math.PI) * x / 180;
        double result = 0;
        for (int i = 0; i < numTerms; i++) {
            result += (i % 2 == 0 ? 1 : -1) * tinhGioiHan(x, 2 * i);
        }
        return result;

    }

    public double exp(int numTerms) {
        double result = 1;
        for (int i = 1; i < numTerms; i++) {
            result += tinhGioiHan(1, (i));
        }
        return result;
    }

    public double exp(double x, int numTerms) {
        double result = 0;
        x = (Math.PI) * x / 180;
        for (int i = 0; i < numTerms; i++) {
            result += tinhGioiHan(x, i);
        }
        return result;
    }
}
