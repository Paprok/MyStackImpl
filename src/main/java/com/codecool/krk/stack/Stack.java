package com.codecool.krk.stack;

public class Stack<T> {
    private T[] stack;
    private int size;
    private int index;

    public Stack(int capacity) {
        this.size = capacity;
        this.stack = (T[]) new Object[capacity];
        this.index = 0;
    }

    public int getSize() {
        return size;
    }
}
