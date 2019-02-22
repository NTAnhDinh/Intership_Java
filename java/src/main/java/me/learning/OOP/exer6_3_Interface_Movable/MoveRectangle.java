package me.learning.OOP.exer6_3_Interface_Movable;

public class MoveRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MoveRectangle(int x, int y, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x, y, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x, y, xSpeed, ySpeed);
    }

    @Override
    public String toString() {
        return "MoveRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }

    @Override
    public void moveUp() {
        topLeft.y -= topLeft.ySpeed;

    }

    @Override
    public void moveDown() {

        bottomRight.y += bottomRight.ySpeed;
    }

    @Override
    public void moveLeft() {
        topLeft.x += topLeft.xSpeed;
    }

    @Override
    public void moveRight() {
        bottomRight.x -= bottomRight.xSpeed;
    }
}
