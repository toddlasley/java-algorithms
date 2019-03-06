package xyz.toddlasley.datastructures.stacks;

public class ResizingArrayStack<T> {
    private T[] a;
    private int N = 0;

    public ResizingArrayStack(){
        this.a = (T[])new Object[1];
    }

    public boolean isEmpty(){
        return this.N == 0;
    }

    // double the size of the array when full
    public void push (T item){
        if(this.N == a.length)
            resize(2 * a.length);
        a[this.N++] = item;
    }

    // shrink array to half its size when 1/4 full
    // this keeps the array between 25% and 100% full.
    // shrinking array to half when it's half full
    // would be too expensive in the worst case
    // (push-pop-push-pop-... sequence when array is full)
    public T pop(){
        T item = a[--this.N];
        a[this.N] = null;
        if(this.N > 0 && this.N == this.a.length / 4)
            resize(this.a.length / 2);

        return item;
    }

    private void resize(int capacity){
        T[] copy = (T[])new Object[capacity];

        for(int i = 0; i < this.N; i++)
            copy[i] = a[i];

        a = copy;
    }
}
