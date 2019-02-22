package me.learning.OOP.exer3_2_MyPolynomial;

public class TestMyPolynomial {
    public static void main(String[] args) {
        // Test program
        // Can invoke with a variable number of arguments
        MyPolynomial p1 = new MyPolynomial(1,1);
        MyPolynomial p2 = new MyPolynomial(4, 0, 1);
//        // Can also invoke with an array
        double[] coeffs = {1.2, 3.4, 5.6, 7.8};
        MyPolynomial p3 = new MyPolynomial(coeffs);
//        System.out.println(p1.add(p2));
//        System.out.println(p1.evaluate(1));
        System.out.println( p1.multi(p2));
    }
}
