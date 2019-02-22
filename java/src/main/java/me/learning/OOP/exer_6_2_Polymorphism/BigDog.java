package me.learning.OOP.exer_6_2_Polymorphism;

public class BigDog extends Animal {
    @Override
    public void greeting() {
        System.out.println("Woow!");
    }

    public void greeting(Dog another) {
        System.out.println("Woooooowwwww!");
    }

}
