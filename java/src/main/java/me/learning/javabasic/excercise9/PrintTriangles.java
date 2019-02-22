package me.learning.javabasic.excercise9;

public class PrintTriangles {
    public static void main(String[] args) {
//        powerOf2Triangle(7);
//        pascalTriangle1(6);
        pascalTriangle2(6);
    }

    public static void powerOf2Triangle(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("\t");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print((int) Math.pow(2, k) + "\t");
            }
            for (int k = i - 1; k >= 0; k--) {
                System.out.print((int) Math.pow(2, k) + "\t");
            }
            System.out.println("");
        }
    }

    public static void pascalTriangle1(int n) {
        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                array[i][j] = 0;

                if (j == 0 || i == j) {

                    array[i][j] = 1;

                } else if (j < i) {

                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1];

                }

            }

        }
// print Pascal Triangle1's array

        for (int c = 0; c < array.length; c++) {

            for (int c2 = 0; c2 < array[0].length; c2++) {

                if (array[c][c2] == 0) {

                    System.out.print(" ");

                } else {

                    System.out.print(array[c][c2] + " ");

                }

            }

            System.out.println();

        }
    }

    public static void pascalTriangle2(int n) {
        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                array[i][j] = 0;

                if (j == 0 || i == j) {

                    array[i][j] = 1;

                } else if (j < i) {

                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1];

                }

            }

        }
// print Pascal Triangle2's array

        for (int k1 = 0; k1 < array.length; k1++) {

            int l = array.length - k1;
//            System.out.print(" ");
            for (int k2 = 0; k2 < l; k2++) {

                System.out.print("  ");

            }

            for (int c2 = 0; c2 <= k1; c2++) {

                System.out.print(array[k1][c2] + "   ");
            }

            System.out.println();

        }
    }
}
