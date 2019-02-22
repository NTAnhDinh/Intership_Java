package me.learning.robotmovement;


public class RobotImpl implements Robot {
    private int x, y;
    private String f;
    final String strDirection = "NORTHSOUTHEASTWEST";
    TableTop table = new TableTop();

    public RobotImpl(int x, int y, String f) {
        this.x = x;
        this.y = y;
        this.f = f;
    }

    public RobotImpl() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getF() {
        return f;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setF(String f) {
        this.f = f;
    }

    @Override
    public String toString() {
        return "I am in position " +
                "x=" + x +
                ", y=" + y +
                ", f='" + f + '\'';
    }

    public boolean isValidMovement(int x, int y, String f) {
        return ((x >= 0 && x < table.getX()) && (y >= 0 && y < table.getY())
                && (strDirection.contains(f.toUpperCase())));

    }

    public boolean go(int x, int y, String f, String command) {
        if (isValidMovement(x, y,f) && command.equalsIgnoreCase("PLACE")) {
            this.setX(x);
            this.setY(y);
            this.setF(f);return  true;
        } else {
            return false;
        }
    }


    @Override
    public boolean move(TableTop tableTop) {
        if (f.toUpperCase().equals("WEST")) {
            if (x > 0 && x < tableTop.getX()) {
                setX(x - 1);// cho phep di chuyen huong ve lai bien 0
                return true;
            } else {
                if (x == 0) {// vuot ra khoi mang nen khong cho di chuyen
                    return false;
                }
            }

        }
        if (f.toUpperCase().equals("SOUTH")) {
            if (y > 0 && y < tableTop.getY()) {
                setY(y - 1);// cho phep di chuyen huong ve lai bien 0
                return true;
            } else {
                if (y == 0) {// vuot ra khoi mang nen khong cho di chuyen
                    return false;
                }
            }

        }
        if (f.toUpperCase().equals("EAST")) {
            if (x >= 0 && x < tableTop.getX() - 1) {
                setX(x + 1);// cho phep di chuyen huong len bien n-1
                return true;
            } else {
                if (x == tableTop.getX() - 1) {// vuot ra khoi mang nen khong cho di chuyen
                    return false;
                }
            }
        }
        if (f.toUpperCase().equals("NORTH")) {
            if (y >= 0 && y < tableTop.getY() - 1) {
                setY(y + 1);// cho phep di chuyen huong len bien n-1
                return true;
            } else {
                if (y == tableTop.getY() - 1) {// vuot ra khoi mang nen khong cho di chuyen
                    return false;
                }
            }
        }

        return false;
    }

    public void reportMovement() {
        System.out.println(toString());

    }

    public void turnLeft() {
        switch (f.toUpperCase()) {
            case "NORTH":
                setF("WEST");
                break;
            case "EAST":
                setF("NORTH");
                break;
            case "SOUTH":
                setF("EAST");
                break;
            case "WEST":
                setF("SOUTH");
                break;
        }
    }

    public void turnRight() {
        switch (f.toUpperCase()) {
            case "NORTH":
                setF("EAST");
                break;
            case "EAST":
                setF("SOUTH");
                break;
            case "SOUTH":
                setF("WEST");
                break;
            case "WEST":
                setF("NORTH");
                break;
        }
    }
}
