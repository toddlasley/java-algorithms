package me.toddlasley.questions.ctci.stacksandqueues;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class FixedMultiStackTest {
    private FixedMultiStack multiStack;

    @Before
    public void intializeStack() throws Exception {
        this.multiStack = new FixedMultiStack(4);
        this.multiStack.push(0, 1);
        this.multiStack.push(0, 2);
        this.multiStack.push(1, 3);
        this.multiStack.push(1, 4);
        this.multiStack.push(1, 5);
        this.multiStack.push(1, 6);
    }


    @Test
    public void isFullIndicatesIfGivenStackIsFull() {
        assertFalse(this.multiStack.isFull(0));
        assertTrue(this.multiStack.isFull(1));
        assertFalse(this.multiStack.isFull(2));
    }

    @Test
    public void indexOfTopReturnsTopIndexOfGivenStack() {
        assertEquals(1, this.multiStack.indexOfTop(0));
        assertEquals(7, this.multiStack.indexOfTop(1));
        assertEquals(7, this.multiStack.indexOfTop(2));

    }

    @Test
    public void isFullIndicatesIfGivenStackIsEmpty() {
        assertFalse(this.multiStack.isEmpty(0));
        assertFalse(this.multiStack.isEmpty(1));
        assertTrue(this.multiStack.isEmpty(2));
    }

    @Test
    public void popPushAndPeekAllInteractWithTheAppropriateStack() throws Exception {
        // stack 0 tests
        assertEquals(2, this.multiStack.pop(0));
        assertEquals(1, this.multiStack.peek(0));

        this.multiStack.push(0, 3);
        assertEquals(3, this.multiStack.peek(0));

        // stack 1 tests
        assertEquals(6, this.multiStack.pop(1));
        assertEquals(5, this.multiStack.peek(1));

        this.multiStack.push(1, 7);
        assertEquals(7, this.multiStack.peek(1));

        // stack 2 tests
        this.multiStack.push(2, 10);
        this.multiStack.push(2, 11);
        assertEquals(11, this.multiStack.peek(2));
        assertEquals(11, this.multiStack.pop(2));
        assertEquals(10, this.multiStack.peek(2));
    }

    @Test ( expected = Exception.class)
    public void popThrowsExceptionIfStackIsEmpty() throws Exception {
        this.multiStack.pop(2);
    }

    @Test ( expected = Exception.class)
    public void pushThrowsExceptionIfStackIsFull() throws Exception {
        this.multiStack.push(1, 10);
    }

    @Test ( expected = Exception.class)
    public void peekThrowsExceptionIfStackIsEmpty() throws Exception {
        this.multiStack.peek(2);
    }
}