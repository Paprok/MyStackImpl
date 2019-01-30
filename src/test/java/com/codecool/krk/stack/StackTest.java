package com.codecool.krk.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {

    @Test
    void testGetSize0Int(){
        Stack<Integer> stack = new Stack<>(0);

        int expected = 0;
        int actual = stack.getSize();

        assertEquals(expected, actual);
    }

    @Test
    void testGetSize6String(){
        int expected = 6;
        Stack<String> stack = new Stack<>(expected);

        int actual = stack.getSize();

        assertEquals(expected, actual);
    }
}
