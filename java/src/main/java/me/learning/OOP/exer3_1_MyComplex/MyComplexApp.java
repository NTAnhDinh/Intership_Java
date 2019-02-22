package me.learning.OOP.exer3_1_MyComplex;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MyComplexApp {
    public void run() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter complex number 1 ");
        String line1 = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line1, " ");
        double real1 = Double.parseDouble(st.nextToken().trim());
        double imag1 = Double.parseDouble(st.nextToken().trim());
        MyComplex complex1 = new MyComplex();
        complex1.setValue(real1, imag1);
        if (!complex1.isImaginary()) {
            System.out.println(complex1.toString() + " is NOT a pure imaginary number");
        } else {
            System.out.println(complex1.toString() + " is a pure imaginary number");
        }
        if (!complex1.isReal()) {
            System.out.println(complex1.toString() + " is NOT a pure real number");
        } else {
            System.out.println(complex1.toString() + " is a pure real number");
        }
        MyComplex temp = new MyComplex(2, 2);
        if (!complex1.equal(temp)) {
            System.out.println(complex1.toString() + "is NOT equal to" + temp.toString());
        }
        else{
            System.out.println(complex1.toString() + "is equal to " + temp.toString());
        }
        System.out.println("Enter complex number 2 ");
        String line2 = sc.nextLine();
        StringTokenizer st2 = new StringTokenizer(line2, " ");
        double real2 = Double.parseDouble(st2.nextToken().trim());
        double imag2 = Double.parseDouble(st2.nextToken().trim());
        MyComplex complex2 = new MyComplex();
        complex2.setValue(real2, imag2);
        if (!complex2.isImaginary()) {
            System.out.println(complex2.toString() + " is NOT a pure imaginary number");
        } else {
            System.out.println(complex2.toString() + " is a pure imaginary number");
        }
        if (!complex2.isReal()) {
            System.out.println(complex2.toString() + " is NOT a pure real number");
        } else {
            System.out.println(complex2.toString() + " is a pure real number");
        }
        MyComplex temp2 = new MyComplex(2, 2);
        if (!complex2.equal(temp2)) {
            System.out.println(complex2.toString() + "is NOT equal to" + temp2.toString());
        }
        else{
            System.out.println(complex2.toString() + "is equal to" + temp2.toString());
        }
      System.out.println( complex1.addNew(complex2));
        System.out.println( complex1.subtractNew(complex2));
        System.out.println( complex1.conjugate());
        System.out.println( complex2.conjugate());
        System.out.println( complex1.multiply(complex2));
        System.out.println( complex1.divide(complex2));
    }
}
