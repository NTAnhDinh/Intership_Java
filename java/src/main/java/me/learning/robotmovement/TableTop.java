package me.learning.robotmovement;

public class TableTop {
   private  int x ;
    private  int y ;
    public TableTop(int x, int y) {
        this.x=x;this.y=y;
    }
    public TableTop() {
        this.x=5;this.y=5;
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
}
