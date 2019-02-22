package me.learning.OOP.exercise7_2_Polyline_of_Points;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points = new ArrayList<>();

    public Polyline() {
    }

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public void appendPoint(int x, int y) {
        Point newPoint = new Point(x, y);
        points.add(newPoint);

    }

    public void appendPoint(Point point) {
        points.add(point);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point p : points) {
            sb.append("(" + p.getX() + ", " + p.getY() + ")");
        }
        sb.append("}");
        return sb.toString();
    }

    public double getLength() {
        return this.points.size();
    }
}
