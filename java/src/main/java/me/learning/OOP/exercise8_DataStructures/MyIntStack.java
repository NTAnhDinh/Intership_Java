package me.learning.OOP.exercise8_DataStructures;

import java.util.Arrays;

public class MyIntStack {
    private int[] contents;

    private int tos;  // Top of the stack

    // constructors
    public MyIntStack(int capacity) {
        contents = new int[capacity];
        tos = -1;
    }

    public int[] getContents() {
        return contents;
    }

    public void setLegthOfContents(int capacity) {
        this.contents = new int[capacity];
    }

    public void setContents(int[] arr) {
        this.contents = arr;
//        this.tos
    }

    public boolean push(int element) {
        int len = contents.length;
        try {

            contents[++tos] = element;
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of range old array");
        }
        return false;
    }

    public int[] push2(int element) {
        int len = contents.length;
        if (!isFull()) {
            push(element);
        } else {
            int[] another = Arrays.copyOf(contents, len + 1);
            another[another.length - 1] = element;
            this.setLegthOfContents(another.length);
            this.tos = another.length - 1;
            this.setContents(another);
        }
        return contents;
    }

    public void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int pop() {

        return contents[tos--];
    }

    public int peek() {
        return contents[tos];
    }

    public boolean isEmpty() {
        return tos < 0;
    }

    public boolean isFull() {

        return tos == contents.length - 1;
    }

    public static void main(String[] args) {
        MyIntStack stack = new MyIntStack(3);
        stack.print(stack.push2(1));
        stack.print(stack.push2(1));
        stack.print(stack.push2(1));
        stack.print(stack.push2(1));
        stack.print(stack.push2(1));
        stack.print(stack.push2(1));
        stack.print(stack.push2(1));
        stack.print(stack.push2(1));
        stack.print(stack.push2(1));
        stack.print(stack.push2(1));
        System.out.println(stack.contents.length);

    }
}
