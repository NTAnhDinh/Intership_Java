package me.learning.robotmovement;

public interface Movable {
    boolean go(int x, int y, String f, String command);
    boolean move(TableTop tableTop);
    void left();
    void right();
    void reportMovement();
}
