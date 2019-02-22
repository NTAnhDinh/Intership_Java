package me.learning.OOP.exer3_1_MyComplex;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;
    private final double EPSILON = 1E-8;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public boolean isReal() {
        return (imag == 0);
    }

    public boolean isImaginary() {
        return (real == 0);
    }

    public boolean equal(double real, double imag) {
        return (this.real == real && this.imag == imag) ? true : Math.abs(this.real - real) < EPSILON
                || Math.abs(this.imag - imag) < EPSILON;
    }

    public boolean equal(MyComplex another) {
        return (this.real == another.real && this.imag == another.imag) ? true : Math.abs(this.real - another.real) < EPSILON
                || Math.abs(this.imag - another.imag) < EPSILON;
    }

    public double magnitude() {
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public double argument() {
        return Math.atan2(this.imag, this.real);
    }

    public MyComplex add(MyComplex right) {
        this.setReal(this.real + right.real);
        this.setImag(this.imag + right.imag);
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        double r = this.real + right.real;
        double i = this.imag + right.imag;
        return new MyComplex(r, i);
    }

    public MyComplex subtract(MyComplex right) {
        this.setReal(this.real - right.real);
        this.setImag(this.imag - right.imag);
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        double r = this.real - right.real;
        double i = this.imag - right.imag;
        return new MyComplex(r, i);
    }

    public MyComplex multiply(MyComplex right) {
        double r = this.real * right.real - this.imag * right.imag;
        double i = this.real * this.imag + right.real * right.imag;
        return new MyComplex(r, i);
    }

    public MyComplex divide(MyComplex right) {
        MyComplex complex = multiply(right.conjugate());
        double div = Math.pow(right.magnitude(), 2);
        return new MyComplex(complex.real / div, complex.imag / div);
    }

    public MyComplex conjugate() {
        return new MyComplex(this.real, -this.imag);
    }

    @Override
    public String toString() {
        return "MyComplex{" +
                "real=" + real +
                ", imag=" + imag +
                "i }";
    }
}
