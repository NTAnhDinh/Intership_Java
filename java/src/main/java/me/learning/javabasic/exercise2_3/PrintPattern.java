package me.learning.javabasic.exercise2_3;

public class PrintPattern {
    public static void main(String[] args) {
        printRectangle(10, 7);
        printShapeZ(4,4);
        printShapeZ2(4,4);
        printShape3(7,7);
        printRectangleWithTwoSide(7,7);
    }

    public static void printTriAngular(int size) {
        for (int i = 1; i <= size; ++i) {
            for (int j = i; j <= size; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = size; i > 0; --i) {
            for (int j = i; j <= size; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printRectangle(int width, int height) {
        for (int i = 1; i <= height; ++i) {
            for (int j = 1; j <= width; ++j) {
                if (j == 1 || j == width || i == 1 || i == height) {
                    System.out.print("* ");
                } else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void printShapeZ(int width, int height) {
        if (width== height) {
            for (int i = 1; i <= height; ++i) {
                for (int j = 1; j <= width; ++j) {
                    if (i == j || i == 1 || i == height) {
                        System.out.print("* ");
                    } else
                        System.out.print("  ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("i cant paint shape Z");
        }
    }
    public static void printShapeZ2(int width, int height) {
        if (width==height) {
            for (int i = 1; i <= height; ++i) {
                for (int j = 1; j <= width; ++j) {
                    if (i == 1 || i == height || i+j==width+1) {
                        System.out.print("* ");
                    } else
                        System.out.print("  ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("i cant paint shape Z");
        }
    }
    public static void printShape3(int width, int height) {
        if (width== height) {
            for (int i = 1; i <= height; ++i) {
                for (int j = 1; j <= width; ++j) {
                    if (i == 1 || i == height || i+j==width+1 ||i==j) {
                        System.out.print("* ");
                    } else
                        System.out.print("  ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("i cant paint shape Z");
        }
    }
    public static void printRectangleWithTwoSide(int width, int height){
        if (width== height) {
            for (int i = 1; i <= height; ++i) {
                for (int j = 1; j <= width; ++j) {
                    if (i == 1 || i == height || i+j==width+1 ||i==j|| j == 1 || j == width) {
                        System.out.print("* ");
                    } else
                        System.out.print("  ");

                }
                System.out.println();
            }
        }
        else{
            System.out.println("i cant paint shape Z");
        }
    }
}

