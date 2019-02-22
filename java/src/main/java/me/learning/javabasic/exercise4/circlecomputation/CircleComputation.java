package me.learning.javabasic.exercise4.circlecomputation;

import java.util.Scanner;

public class CircleComputation {
    public double area(int radius){
        return (double)Math.round(Math.PI*radius*radius*100)/100;
    }
    public double circumference(int radius){
return (double)Math.round(Math.PI*radius*2*100)/100;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);



// Read first input
        System.out.print("Enter a positive integer or -1 to exit: ");
        int radius = in.nextInt();
        CircleComputation c = new CircleComputation();
        while (radius != -1) {
            System.out.println("The area is: " + c.area(radius));
            System.out.println("The circumference is: " + c.circumference(radius));
            // Read next input (Take note that you need to repeat these statements)
            System.out.print("Enter a positive integer or -1 to exit: ");
            radius = in.nextInt();
        }
        System.out.println("Finish!!");
        in.close();





    }
}
