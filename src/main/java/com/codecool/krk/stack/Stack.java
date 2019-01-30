package com.codecool.krk.stack;

import com.codecool.krk.StackOverflow;

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

    public int getSizeLeft() {
        return size - index;
    }

    public void push(T item) throws StackOverflow{
        if(this.index >= this.size){
            throw new StackOverflow();
        }
        this.stack[this.index] = item;
        ++this.index;
    }

    public T peek(){
        return this.stack[index-1];
    }

    public T pop(){
        return this.stack[--index];
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i =0; i<index; i++){
            builder.append(stack[i]);
            builder.append(' ');
        }
        return builder.toString().trim();
    }
}
