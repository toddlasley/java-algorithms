package xyz.toddlasley.ctci.stacksandqueues;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class SortStackTest {

    @Test
    public void sortSuccessfullySortsStack() {

        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(0);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);

        SortStack.sort(stack1);

        assertEquals(0, (int)stack1.pop());
        assertEquals(1, (int)stack1.pop());
        assertEquals(2, (int)stack1.pop());
        assertEquals(3, (int)stack1.pop());
        assertEquals(4, (int)stack1.pop());
        assertEquals(5, (int)stack1.pop());
        assertEquals(6, (int)stack1.pop());

        Stack<Integer> stack2 = new Stack<Integer>();
        stack2.push(7);
        stack2.push(9);
        stack2.push(11);
        stack2.push(13);
        stack2.push(8);
        stack2.push(12);
        stack2.push(10);

        SortStack.sort(stack2);

        assertEquals(7, (int)stack2.pop());
        assertEquals(8, (int)stack2.pop());
        assertEquals(9, (int)stack2.pop());
        assertEquals(10, (int)stack2.pop());
        assertEquals(11, (int)stack2.pop());
        assertEquals(12, (int)stack2.pop());
        assertEquals(13, (int)stack2.pop());
    }

    @Test
    public void sortLeavesSortedStackAlone() {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(0);

        SortStack.sort(stack);

        assertEquals(0, (int)stack.pop());
        assertEquals(1, (int)stack.pop());
        assertEquals(2, (int)stack.pop());
        assertEquals(3, (int)stack.pop());
        assertEquals(4, (int)stack.pop());
        assertEquals(5, (int)stack.pop());
        assertEquals(6, (int)stack.pop());
    }
}