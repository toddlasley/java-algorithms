// 3.1: Describe how you could use a single array to implement three stacks.
// Solution: p. 227

package me.toddlasley.questions.ctci.stacksandqueues;

public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack (int stackSize) {
        this.stackCapacity = stackSize;
        this.values = new int[ stackSize * this.numberOfStacks];
        this.sizes = new int[stackSize];
    }

    public void push (int stackIndex, int value) throws Exception {
        if ( this.isFull(stackIndex) ) {
            throw new Exception(String.format("Stack %d is full", stackIndex));
        }

        this.sizes[stackIndex]++;
        this.values[this.indexOfTop(stackIndex)] = value;
    }

    public int pop (int stackIndex) throws Exception {
        if ( this.isEmpty(stackIndex) ) {
            throw new Exception(String.format("Stack %d is empty"));
        }

        int indexOfTop = this.indexOfTop(stackIndex);
        int value = this.values[indexOfTop];
        this.values[indexOfTop] = 0;
        this.sizes[stackIndex]--;

        return value;
    }

    public int peek (int stackIndex) throws Exception {
        if ( this.isEmpty(stackIndex)) {
            throw new Exception(String.format("Stack %d is empty"));
        }

        return this.values[this.indexOfTop(stackIndex)];
    }

    public boolean isEmpty (int stackIndex) {
        return this.sizes[stackIndex] == 0;
    }

    public boolean isFull (int stackIndex) {
        return this.sizes[stackIndex] == this.stackCapacity;
    }

    public int indexOfTop(int stackIndex) {
        int offset = stackIndex * this.stackCapacity;

        return offset + this.sizes[stackIndex] - 1;
    }
}
