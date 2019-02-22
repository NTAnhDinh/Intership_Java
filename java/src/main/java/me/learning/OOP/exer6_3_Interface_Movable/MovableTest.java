package me.learning.OOP.exer6_3_Interface_Movable;

public class MovableTest {
    public static void main(String[] args) {
        Movable m1 = new MovablePoint(5, 6, 10, 15);     // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);
        System.out.println("--------------------------------------");
        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);  // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);
        System.out.println("--------------------------------------");
        Movable m3 = new MoveRectangle(5, 6, 10, 15);
        m3.moveUp();
        m3.moveDown();
        m3.moveLeft();
        m3.moveRight();
        System.out.println(m3);
    }
}
