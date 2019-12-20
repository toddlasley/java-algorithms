package xyz.toddlasley.ctci.stacksandqueues;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class SetOfStacksTest {

    @Test
    public void PushAddValuesToSetOfStacksAndGetLastStackReturnsTheLastStack () {
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);

        Stack lastStack = setOfStacks.getLastStack();

        assertEquals(1, lastStack.size());
        assertEquals(5, lastStack.peek());
    }

    @Test
    public void getLastStackReturnsNullIfSetOfStacksIsEmpty () {
        SetOfStacks setOfStacks = new SetOfStacks(2);

        assertNull(setOfStacks.getLastStack());
    }

    @Test
    public void popReturnsLastPushedValue () throws Exception {
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);

        assertEquals(5, (int)setOfStacks.pop());
    }

    @Test ( expected = Exception.class )
    public void popThrowsErrorIfSetOfStacksIsEmpty () throws Exception {
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.pop();
    }
}