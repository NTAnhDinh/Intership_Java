package me.learning.robotmovement;

public interface Robot {
    boolean go(int x, int y, String f, String command);
    boolean move(TableTop tableTop);
    void turnLeft();
    void turnRight();
    void reportMovement();
}

