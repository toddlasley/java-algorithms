// 3.2: How would you design a stack which, in addition to 'push' and 'pop', has a function
//      'min' which returns the minimum element? 'Push', 'pop', and 'min' must operate in O(1)
//      time.
//
// Question doesn't specify, but given the book's implementation, I assume we are only dealing
// with unique values

package me.toddlasley.questions.ctci.stacksandqueues;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
    private Stack<Integer> minStack;

    public StackWithMin() {
        this.minStack = new Stack<Integer>();
    }

    public void push (int value) {
        if ( value < this.min() ) {
            this.minStack.push(value);
        }

        super.push(value);
    }

    public Integer pop () {
        int value = super.pop();

        if ( value == min() ) {
            minStack.pop();
        }

        return value;
    }

    public int min () {
        return this.minStack.isEmpty() ? Integer.MAX_VALUE : this.minStack.peek();
    }
}
