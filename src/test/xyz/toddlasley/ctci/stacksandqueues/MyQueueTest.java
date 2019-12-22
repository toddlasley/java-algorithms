package xyz.toddlasley.ctci.stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    @Test
    public void myQueuObjectsOffersCoreQueueDataStructureFunctionality () {
        MyQueue myQueue = new MyQueue<Integer>();
        myQueue.enqueue(0);
        myQueue.enqueue(1);
        myQueue.enqueue(2);

        assertEquals(3, myQueue.size());
        assertEquals(0, myQueue.peek());
        assertEquals(3, myQueue.size());
        assertEquals(0, myQueue.dequeue());
        assertEquals(2, myQueue.size());

        myQueue.enqueue(3);
        myQueue.enqueue(4);

        assertEquals(4, myQueue.size());
        assertEquals(1, myQueue.peek());
        assertEquals(4, myQueue.size());
        assertEquals(1, myQueue.dequeue());
        assertEquals(3, myQueue.size());
    }
}