// 3.4: Implement a MyQueue class which implements a queue using two stacks.
// Solution: p. 236

package me.toddlasley.questions.ctci.stacksandqueues;

import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> newest;
    private Stack<T> oldest;

    public MyQueue () {
        this.newest = new Stack<T>();
        this.oldest = new Stack<T>();
    }

    public int size () {
        return this.newest.size() + this.oldest.size();
    }

    public void enqueue (T value) {
        this.newest.push(value);
    }

    public T dequeue () {
        this.shiftStacks();
        return this.oldest.pop();
    }

    public T peek () {
        this.shiftStacks();
        return this.oldest.peek();
    }

    private void shiftStacks () {
        if ( this.oldest.isEmpty() ) {
            while ( !this.newest.isEmpty() ) {
                this.oldest.push(this.newest.pop());
            }
        }
    }
}
