package com.codecool.krk.stack;

import com.codecool.krk.StackOverflow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {

    @Test
    void testGetSize0Int() {
        Stack<Integer> stack = new Stack<>(0);

        int expected = 0;
        int actual = stack.getSize();

        assertEquals(expected, actual);
    }

    @Test
    void testGetSize6String() {
        int expected = 6;
        Stack<String> stack = new Stack<>(expected);

        int actual = stack.getSize();

        assertEquals(expected, actual);
    }

    @Test
    void testGetSizeLeftEmptyStack() {
        int expected = 5;
        Stack<String> stack = new Stack<>(expected);

        int actual = stack.getSizeLeft();

        assertEquals(expected, actual);
    }

    @Test
    void testGetSizeLeftAfterPush() {
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);
        int numberToPush = 1;
        addItemsToStack(numberToPush, stack);

        int expected = size - numberToPush;
        int actual = stack.getSizeLeft();

        assertEquals(expected, actual);
    }

    private void addItemsToStack(int howMany, Stack<Integer> stack) {
        for (int i = 0; i < howMany; i++) {
            stack.push(i);
        }
    }

    @Test
    void testGetSizeLeftAfterFilling() {
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);
        int numberToPush = size;

        addItemsToStack(numberToPush, stack);
        int expected = size - numberToPush;
        int actual = stack.getSizeLeft();

        assertEquals(expected, actual);
    }

    @Test
    void testPushOverSizeThrowsException() {
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);
        addItemsToStack(size, stack);

        assertThrows(StackOverflow.class,
                () -> stack.push(666)
        );
    }

    @Test
    void testToStringEmptyStack() {
        Stack<Integer> stack = new Stack<>(5);

        String expected = "";
        String actual = stack.toString();

        assertEquals(actual, expected);
    }

    @Test
    void testToStringAfterOnePush() {
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);
        int numberToPush = 1;
        addItemsToStack(numberToPush, stack);

        String expected = "0";
        String actual = stack.toString();

        assertEquals(actual, expected);
    }

    @Test
    void testToStringAfterFillingStack() {
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);
        addItemsToStack(size, stack);

        String expected = "0 1 2 3 4";
        String actual = stack.toString();

        assertEquals(actual, expected);
    }

    @Test
    void testPeekOnEmptyStackThrowsException() {
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);

        assertThrows(IndexOutOfBoundsException.class,
                () -> stack.peek()
        );
    }

    @Test
    void testPeekOn1StringStackSized5() {
        Stack<String> stack = new Stack<>(5);
        String expected = "something";
        stack.push(expected);

        String actual = stack.peek();

        assertEquals(expected, actual);
    }

    @Test
    void testPeekOn1BoolStackSized1() {
        Stack<Boolean> stack = new Stack<>(1);
        Boolean expected = true;
        stack.push(expected);

        Boolean actual = stack.peek();

        assertEquals(expected, actual);
    }

    @Test
    void testPeekOnMidFilledStack() {
        int size = 10;
        Stack<Integer> stack = new Stack<>(size);
        int howMany = 6;
        addItemsToStack(howMany, stack);

        int expected = howMany - 1;
        int acutal = stack.peek();

        assertEquals(expected, acutal);
    }

    @Test
    void testPeekOnFullStack() {
        int size = 5;
        Stack<Integer> stack = new Stack<>(size);
        addItemsToStack(size,  stack);

        int expected = 4;
        int actual = stack.peek();

        assertEquals(expected, actual);
    }

    @Test
    void testPopOn1StringStackSized1() {
        int size = 1;
        Stack<String> stack = new Stack<>(size);
        String expected = "something";
        stack.push(expected);

        String actual = stack.pop();

        assertEquals(expected, actual);
        assertEquals(size, stack.getSizeLeft());
    }

    @Test
    void testPopOnEmptyStackThrowsException() {
        Stack<String> stack = new Stack<>(5);

        assertThrows(IndexOutOfBoundsException.class,
                () -> stack.pop()
        );
    }

    @Test
    void testPopOn1BooleanStackSized5() {
        int size = 5;
        Stack<Boolean> stack = new Stack<>(size);
        Boolean expected = true;
        stack.push(expected);

        Boolean actual = stack.pop();

        assertEquals(expected, actual);
        assertEquals(size, stack.getSizeLeft());
    }

    @Test
    void testPopOnMidFilledStackOfInts() {
        int size = 10;
        Stack<Integer> stack = new Stack<>(size);
        addItemsToStack(5, stack );

        int expected = 4;
        String expectedStr = "0 1 2 3";
        int actual = stack.pop();
        String actualStr = stack.toString();

        assertEquals(expected, actual);
        assertEquals(expectedStr, actualStr);
    }

    @Test
    void testPopOnFullStackOfInts() {
        int size = 10;
        Stack<Integer> stack = new Stack<>(size);
        addItemsToStack(size, stack );

        int expected = 9;
        String expectedStr = "0 1 2 3 4 5 6 7 8";
        int actual = stack.pop();
        String actualStr = stack.toString();

        assertEquals(expected, actual);
        assertEquals(expectedStr, actualStr);
    }
}
