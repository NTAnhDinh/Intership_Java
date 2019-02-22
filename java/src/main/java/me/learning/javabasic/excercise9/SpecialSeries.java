package me.learning.javabasic.excercise9;

public class SpecialSeries {
    public static void main(String[] args) {
        SpecialSeries ss = new SpecialSeries();
        double x = 2;
        int numTerms = 3;
        System.out.println(ss.sumOfSeries(x, numTerms));
    }

    /**
     * phuong thuc nay dung de tinh tong cua 1 bieu thuc
     *
     * @param x        :   bien x trong bieu thuc
     * @param numTerms : gioi han cua bieu thuc
     * @return : double
     */
    public double sumOfSeries(double x, int numTerms) {
        double result = 0;
        result += x;
        for (int i = 1; i <= numTerms; i++) {
            result += tinhCoSo(i - 1) * (Math.pow(x, 2 * i + 1) / (2 * i + 1));
        }
        return result;
    }

    /**
     * phuong thuc nay dung de tinh co so cua 1  phan tu trong bieu thuc
     *
     * @param numTerms : la gioi han cua mot phan tu
     * @return : double
     */
    public double tinhCoSo(int numTerms) {
        double term = 1.0;
        for (int i = 0; i <= numTerms; i++) {
            term *= (double) (2 * i + 1) / (2 * (i + 1));
        }
        return term;
    }

}
