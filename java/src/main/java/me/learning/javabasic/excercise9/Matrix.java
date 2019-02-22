package me.learning.javabasic.excercise9;

public class Matrix {
    public static void main(String[] args) {
        int[][] m1 = {{2, 3, 4}, {1, 0, 0}};
        int[][] m2 = {{0, 1000}, {1, 100}, {0, 10}};
        System.out.println(haveSameDimension(m1, m2));
        printMatrix(multiplication(m1, m2));
    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");

            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");

            }
            System.out.println();
        }
    }

    public static boolean haveSameDimension(int[][] m1, int[][] m2) {
        boolean isSameDimesionCol = false;
        boolean isSameDimesionRow = false;
        if (m1.length == m2.length) {
            isSameDimesionRow = true;
        }
        if (m1[0].length == m2[0].length) {
            isSameDimesionCol = true;
        }
        return isSameDimesionCol && isSameDimesionRow;
    }

    public static boolean haveSameDimension(double[][] m1, double[][] m2) {
        boolean isSameDimesionCol = false;
        boolean isSameDimesionRow = false;
        if (m1.length == m2.length) {
            isSameDimesionRow = true;
        }
        if (m1[0].length == m2[0].length) {
            isSameDimesionCol = true;
        }
        return isSameDimesionCol && isSameDimesionRow;
    }

    public static int[][] add(int[][] m1, int[][] m2) {
        if (haveSameDimension(m1, m2)) {
            int[][] result = new int[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    result[i][j] = m1[i][j] + m2[i][j];
                }
            }
            return result;
        } else {
            return null;
        }


    }

    public static double[][] add(double[][] m1, double[][] m2) {
        if (haveSameDimension(m1, m2)) {
            double[][] result = new double[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    result[i][j] = m1[i][j] + m2[i][j];
                }
            }
            return result;
        } else {
            return null;
        }

    }

    public static int[][] subtraction(int[][] m1, int[][] m2) {
        if (haveSameDimension(m1, m2)) {
            int[][] result = new int[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    result[i][j] = m1[i][j] - m2[i][j];
                }
            }
            return result;
        } else {
            return null;
        }


    }

    public static double[][] subtraction(double[][] m1, double[][] m2) {
        if (haveSameDimension(m1, m2)) {
            double[][] result = new double[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    result[i][j] = m1[i][j] - m2[i][j];
                }
            }
            return result;
        } else {
            return null;
        }

    }

    public static int[][] multiplication(int[][] m1, int[][] m2) {
        if (m1[0].length == m2.length) {
            int[][] result = new int[m1.length][m2[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int k = 0; k < result.length; k++) {
                    for (int j = 0; j < m2.length; j++) {
                        result[i][k] += m1[i][j] * m2[j][k];
                    }

                }

            }
            return result;
        }
        return null;
    }

    public static double[][] multiplication(double[][] m1, double[][] m2) {
        if (m1[0].length == m2.length) {
            double[][] result = new double[m1.length][m2[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int k = 0; k < result.length; k++) {
                    for (int j = 0; j < m2.length; j++) {
                        result[i][k] += m1[i][j] * m2[j][k];
                    }

                }

            }
            return result;
        }
        return null;
    }
}
