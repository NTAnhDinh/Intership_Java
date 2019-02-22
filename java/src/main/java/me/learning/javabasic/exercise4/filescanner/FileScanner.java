package me.learning.javabasic.exercise4.filescanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {
    public static void main(String[] args)
            throws FileNotFoundException {  // Needed for file operation
        int num1;
        double num2;
        String name;
        double sum;

        // Setup a Scanner to read from a text file
        Scanner in = new Scanner(new File("D:\\java\\src\\main\\java\\me\\learning\\javabasic\\exercise4\\filescanner\\in.txt"));
        num1 = in.nextInt();      // use nextInt() to read int
        num2 = in.nextDouble();   // use nextDouble() to read double
        name = in.next();         // use next() to read String

        // Display

        System.out.println("The integer read is "+ num1);
        System.out.println("The floating point number read is "+ num2);
        System.out.println("The String read is "+ name);
        System.out.println("Hi! "+name+" , the sum of"+num1+" and "+num2+" is : "+ num1+num2);




        in.close();
    }

}
