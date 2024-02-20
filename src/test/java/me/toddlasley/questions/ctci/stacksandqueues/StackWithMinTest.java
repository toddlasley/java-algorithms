package me.toddlasley.questions.ctci.stacksandqueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackWithMinTest {
    private StackWithMin stack;

    @Before
    public void initializeStack () {
        this.stack = new StackWithMin();
        this.stack.push(5);
        this.stack.push(3);
        this.stack.push(6);
        this.stack.push(7);
        this.stack.push(8);
    }

    @Test
    public void pushAddsValueToStackAndSetsNewMinAccordingly () {
        assertEquals(3, this.stack.min());
        this.stack.push(2);
        this.stack.push(10);
        assertEquals(10, (int)this.stack.peek());
        assertEquals(2, this.stack.min());
    }

    @Test
    public void popRemovesValueFromStackAndSetsNewMinAccordingly () {
        assertEquals(8, (int)this.stack.pop());
        assertEquals(3, this.stack.min());

        assertEquals(7, (int)this.stack.pop());
        assertEquals(3, this.stack.min());

        assertEquals(6, (int)this.stack.pop());
        assertEquals(3, this.stack.min());

        assertEquals(3, (int)this.stack.pop());
        assertEquals(5, this.stack.min());
    }

    @Test
    public void minReturnsIntegerMaxValueIfMinStackIsEmpty () {
        this.stack = new StackWithMin();

        assertEquals(Integer.MAX_VALUE, this.stack.min());
    }
}