// 3.3: Imagine a literal stack of plates. If the stack gets too high, it might topple. Therefore,
//      in real life, we would likely start a new stack when the previous stack exceeds some threshold.
//      Implement a data structure 'SetOfStacks' that mimics this. 'SetOfStacks' should be composed
//      of several stacks and should create a new stack once the previous one exceeds capacity. 'Push'
//      and 'pop' should behave identically to a single stack.
// Solution: p. 233

package xyz.toddlasley.ctci.stacksandqueues;

import java.util.Stack;
import java.util.ArrayList;

public class SetOfStacks {
    private ArrayList<Stack<Integer>> stacks;
    private int capacity;

    public SetOfStacks(int capacity) {
        this.stacks = new ArrayList<Stack<Integer>>();
        this.capacity = capacity;
    }

    public Stack getLastStack () {
        return this.stacks.size() == 0 ? null : this.stacks.get(this.stacks.size() - 1);
    }

    public void push (int value) {
        Stack lastStack = this.getLastStack();

        if ( lastStack != null && lastStack.size() != this.capacity ) {
            lastStack.push(value);
        } else {
            Stack newStack = new Stack<Integer>();
            newStack.push(value);
            this.stacks.add(newStack);
        }
    }

    public Integer pop () throws Exception {
        Stack lastStack = this.getLastStack();

        if ( lastStack != null && lastStack.size() > 0 ) {
            int value = (int)lastStack.pop();

            if ( lastStack.size() == 0 ) {
                this.stacks.remove( this.stacks.size() - 1 );
            }

            return value;
        } else {
            throw new Exception("SetOfStacks is empty");
        }

    }
}