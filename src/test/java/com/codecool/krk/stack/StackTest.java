package com.codecool.krk.stack;

import com.codecool.krk.StackOverflow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void testGetSizeLeftEmptyStack(){
        int expected = 5;
        Stack<String> stack = new Stack<>(expected);

        int actual = stack.getSizeLeft();

        assertEquals(expected, actual);
    }

    @Test
    void testGetSizeLeftAfterPush(){
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);
        int expected = fillStackGetExpected(1, size, stack);
        int actual = stack.getSizeLeft();

        assertEquals(expected, actual);
    }

    private int fillStackGetExpected(int howMany, int size, Stack<Integer> stack) {
        for(int i = 0; i<howMany; i++) {
            stack.push(i);
            --size;
        }
        return size;
    }

    @Test
    void testGetSizeLeftAfterFilling(){
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);

        int expected = fillStackGetExpected(size, size, stack);
        int actual = stack.getSizeLeft();

        assertEquals(expected, actual);
    }

    @Test
    void testPushOverSizeThrowsException(){
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);

        fillStackGetExpected(size,size,stack);
        assertThrows(StackOverflow.class,
                ()->stack.push(666)
        );
    }
    

}
