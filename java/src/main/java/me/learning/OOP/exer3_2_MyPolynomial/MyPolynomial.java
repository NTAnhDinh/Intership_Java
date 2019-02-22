package me.learning.OOP.exer3_2_MyPolynomial;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDree() {

        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (i == 0) {
                s += coeffs[i];
            } else {
                s += coeffs[i] + "*x^" + i + "+";
            }
        }
        return s;
    }

    public double evaluate(double x) {
        double s = 0.0;
        for (int i = coeffs.length - 1; i >= 0; i--) {

            s += coeffs[i] * Math.pow(x, i);
        }
        return s;
    }

    public MyPolynomial add(MyPolynomial right) {
        int maxSize = Math.max(this.coeffs.length, right.coeffs.length);
        int minsize = Math.min(this.coeffs.length, right.coeffs.length);
        MyPolynomial polynomialResult = new MyPolynomial(new double[maxSize]);
        for (int i = 0; i < minsize; i++) {
            polynomialResult.coeffs[i] = this.coeffs[i] + right.coeffs[i];

        }
        if (maxSize == this.coeffs.length) {
            for (int i = minsize; i < maxSize; i++) {
                polynomialResult.coeffs[i] = this.coeffs[i];
            }
        }
        if (maxSize == right.coeffs.length) {
            for (int i = minsize; i < maxSize; i++) {
                polynomialResult.coeffs[i] = right.coeffs[i];
            }
        }
        return polynomialResult;
    }

    public MyPolynomial multi(MyPolynomial right) {
        int exponent = this.getDree() + right.getDree();
//        System.out.println(exponent);
        double[][] arr = new double[exponent + 1][exponent*2 + 1];//mang chua he so nhan phan phoi, xep theo tung vi tri mu
        double[] r = new double[exponent + 1];// mang chua he so cuoi cung cua bieu thuc
        for (int i = 0; i < this.coeffs.length; i++) {
            for (int j = 0; j < right.coeffs.length; j++) {
                arr[i+j][i] = this.coeffs[i] * right.coeffs[j];
            }
        }
        for (int k1 = 0; k1 <arr.length; k1++) {
            for (int k2 = 0; k2 <arr[0].length; k2++) {
                r[k1] += arr[k1][k2];
            }
        }
        return new MyPolynomial(r);
    }

}
