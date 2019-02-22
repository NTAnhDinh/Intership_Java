package me.learning.javabasic.excercise9;

public class PrintPatterns {
    public static void main(String[] args) {
//        printTamGiacNguoc(6);
        printTamGiac(6);
//        printHinhThoi(6);
//        printTamGiacVuongCanNguocBenPhai(8);
//        printTamGiacVuongCanBenPhai(8);
//        printTamGiacVuongCanNguocBenTrai(8);
//        printHinhH(7);
//        printHinhI(7);
//        printHinhJ(7);
//        printHinhL(7);
        printHinhK(8);
    }

    public static void printTamGiacNguoc(int n) {
        if (n <= 0) {
            System.out.println("The size of shape must be positive");
        } else {
            int c = 0;
            for (int i = n * 2; i > n; i--) {
                for (int j = 0; j < c; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k < i - c; k++) {
                    System.out.print("*");
                }
                c = c + 1;
                System.out.println("");
            }
        }
    }

    public static void printTamGiac(int n) {
        if (n <= 0) {
            System.out.println("The size of shape must be positive");
        } else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= i; k++) {
                    System.out.print("*");
                }
                for (int k = 2; k <= i; k++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }

    public static void printHinhThoi(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            for (int k = 2; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = n - i - 1; k > 0; k--) {
                System.out.print("*");
            }
            for (int k = n - i; k >= 1; k--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void printTamGiacVuongCanBenTrai(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println("");
        }
    }

    public static void printTamGiacVuongCanNguocBenPhai(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println("");
        }
    }

    public static void printTamGiacVuongCanBenPhai(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n - i; k++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println("");
        }
    }

    public static void printTamGiacVuongCanNguocBenTrai(int n) {
        for (int i = n; i > 0; i--) {

            for (int k = i; k >= 1; k--) {
                System.out.print(k + " ");
            }

            System.out.println("");
        }
    }

    public static void printHinhH(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k1 = 1; k1 <= i; k1++) {
                System.out.print(k1);
            }
            for (int k2 = i - 1; k2 >= 1; k2--) {
                System.out.print(k2);
            }
            System.out.println("");
        }
    }

    public static void printHinhI(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k1 = 1; k1 <= i; k1++) {
                System.out.print(k1);
            }
            for (int k2 = i - 1; k2 >= 1; k2--) {
                System.out.print(k2);
            }
            System.out.println("");
        }
    }


    public static void printHinhJ(int n) {
        for (int i = 1; i < n; i++) {
            for (int c1 = 1; c1 <= i; c1++) {
                System.out.print(c1 + " ");
            }
            for (int k = 2; k <= (n - i) * 2; k++) {
                System.out.print(" ");
                System.out.print(" ");
            }
            for (int c2 = i; c2 >= 1; c2--) {
                System.out.print(c2 + " ");
            }
            System.out.println("");
        }
        //2 vong for in day
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        for (int j = n - 1; j >= 1; j--) {
            System.out.print(j + " ");
        }
    }

    public static void printHinhK(int n) {
        //2 vong for in duong vien tren
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        for (int j = n - 1; j >= 1; j--) {
            System.out.print(j + " ");
        }
        System.out.println("");
        for (int i = n; i > 0; i--) {
            for (int k = 1; k < i; k++) {
                System.out.print(k + " ");

            }
            //in dau cach cho phan rong
            for (int l = (n - i) * 2; l >= 0; l--) {
                System.out.print(" ");
                System.out.print(" ");
            }

            for (int k = 1; k < i; k++) {
                System.out.print(k + " ");

            }
            System.out.println("");

        }

    }

    public static void printHinhL(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
                System.out.print(" ");
            }
            for (int k1 = i + 1; k1 <= i * 2 + 1; k1++) {
                if (k1 > 9) {
                    System.out.print(k1 - 10 + " ");
                } else {
                    System.out.print(k1 + " ");
                }
            }
            for (int k2 = i * 2; k2 > i; k2--) {
                if (k2 > 9) {
                    System.out.print(k2 - 10 + " ");
                } else {
                    System.out.print(k2 + " ");
                }
            }
            System.out.println("");
        }
    }
}
