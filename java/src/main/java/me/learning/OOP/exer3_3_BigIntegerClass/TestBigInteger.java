package me.learning.OOP.exer3_3_BigIntegerClass;

import java.math.BigInteger;

public class TestBigInteger {
    public static void main(String[] args) {
        byte[] c1= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
      byte[] c2 ={2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        BigInteger i1 = new BigInteger(c1);
        BigInteger i2 = new BigInteger(c2);
        System.out.println(i1.add(i2));
        System.out.println(i1.multiply(i2));
    }

}
