//priority queue that keeps track of top M values

//this is an ordered array implementation.
//an unordered array implementation would result in
//linear performance for get/delete max and constant
//performance for inserting

//the get/delete operation for this operates in constant time
//inserting a value is proportional to O(n) (due to the need to rearrange
//the array)

//max value is the last value in the array
//min value is at the beginning of the array

//limitation: this implementation does not account for overflow or
//underflow of the array

package me.toddlasley.datastructures.queues;

public class MaxPriorityQueue<T extends Comparable<T>> {

    private T[] pq;
    private int n;

    //provide capacity because we are only looking to keep track of the
    //top # of values
    public MaxPriorityQueue(int capacity){
        pq = (T[]) new Comparable[capacity];
    }

    public boolean isEmpty(){
        return this.n == 0;
    }

    public int size(){
        return this.n;
    }

    public void insert(T x){
        int i = this.n - 1;

        while(i >= 0 && less(x, this.pq[i])){
            pq[i + 1] = pq[i];
            i--;
        }
        this.pq[i + 1] = x;
        this.n++;
    }

    public Comparable delMax(){
        T maxValue = this.pq[this.n - 1];
        this.pq[this.n - 1] = null;
        this.n--;

        return maxValue;
    }

    //is x less than y?
    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    public static void main(String[] args) {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<Integer>(5);
        pq.insert(5);
        pq.insert(4);
        pq.insert(3);
        pq.insert(1);
        pq.insert(2);

        while (!pq.isEmpty()) {
            System.out.println(pq.delMax());
        }
    }
}
