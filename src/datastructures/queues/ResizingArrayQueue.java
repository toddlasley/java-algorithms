package datastructures.queues;

import java.util.NoSuchElementException;

public class ResizingArrayQueue<T>
{
    private T[] a;
    private int n;
    private int first; //points to the first object if there is one
    private int last; //points to next available element

    public ResizingArrayQueue() {
        this.a = (T[]) new Object[2];
        this.n = 0;
        this.first = 0;
        this.last = 0;
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size() {
        return this.n;
    }

    // double the size of the array when full
    public void enqueue(T item)
    {
        if(this.n == this.a.length)
            this.resize(2 * this.a.length);
        a[this.last++] = item;

        //if last is past the end of the array,
        //start back at the beginning
        if(this.last == this.a.length)
            last = 0;

        this.n++;
    }

    // shrink array to half its size when 1/4 full
    // this keeps the array between 25% and 100% full.
    // shrinking array to half when it's half full
    public T dequeue()
    {
        if(this.isEmpty())
            throw new NoSuchElementException("Queue underflow");

        T item = this.a[this.first];
        this.a[this.first] = null;
        this.n--;
        this.first++;

        //if first is past the end of the array
        // start back at the beginning
        if(this.first == this.a.length)
            first = 0;

        if(this.n > 0 && this.n == this.a.length / 4)
            this.resize(this.a.length / 2);

        return item;
    }

    private void resize(int capacity){
        assert capacity >= this.n;
        T[] temp = (T[]) new Object[capacity];

        for(int i = 0; i < this.n; i++) {
            //the modulus is to account for any "wrap around"
            // i.e. first index > last
            temp[i] = this.a[(first + i) % this.a.length];
        }
        this.a = temp;
        this.first = 0;
        this.last = this.n;
    }
}