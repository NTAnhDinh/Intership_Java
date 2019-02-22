package me.learning.OOP.exercise7_2_Polyline_of_Points;

import java.util.*;

public class TestPolyLine {
    public static void main(String[] args) {
        // Test default constructor and toString()
        Polyline l1 = new Polyline();
        System.out.println(l1);  // {}

        // Test appendPoint()
        l1.appendPoint(new Point(1, 2));
        l1.appendPoint(3, 4);
        l1.appendPoint(5, 6);
        System.out.println(l1);  // {(1,2)(3,4)(5,6)}

        // Test constructor 2
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(11, 12));
        points.add(new Point(13, 14));
        Polyline l2 = new Polyline(points);
        System.out.println(l2);  // {(11,12)(13,14)}
    }

}
