package me.learning.OOP.exer_6_2_Polymorphism;

public class Dog extends  Animal {
    @Override
    public void greeting() {
        System.out.println("Woof!");
    }
    public void greeting(Dog another) {
        System.out.println("Woooooooooof!");
    }

}
