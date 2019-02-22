package me.learning.OOP.exercise6_1_Abstract_Superclass_Shape;

public class Square extends  Shape {
    private double size;

    public Square(String color, boolean filled,double size) {
        super(color, filled);
        this.size = size;
    }

    public Square(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
