package me.learning.OOP.exercise7_2_Polyline_of_Points;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ')';
    }

    public double distance(Point another) {
        return Math.sqrt(Math.pow((x - another.getX()), 2) + Math.pow(y - another.getY(), 2));
    }
}
