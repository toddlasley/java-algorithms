// binary heap implementation of priority queue.
// this addresses all limitations that are mentioned for MaxPriorityQueue
// (thanks to a resizing array) and performs all of the operations better.

// because of the tree structure, the performance of inserting a value and
// deleting the max is proportional to lg N, while getting the max is done in
// constant time

package datastructures.queues;

public class MaxPQBinaryHeap<T extends Comparable<T>> {
    private T[] pq;
    private int n;

    public MaxPQBinaryHeap(int capacity){
        this.pq = (T[]) new Comparable[capacity + 1];
        this.n = 0;
    }

    public MaxPQBinaryHeap(){
        this(1);
    }

    public boolean isEmpty(){
        return this.n == 0;
    }

    public int size(){
        return this.n;
    }

    public T max(){
        return this.pq[1];
    }

    public T delMax(){
        T max = this.pq[1];

        //move node at the end of array
        //to the root
        this.pq[1] = this.pq[this.n--];
        this.pq[this.n + 1] = null;

        this.sink(1);

        // shrink array to half its size when 1/4 full
        if(this.n > 0 && (this.n == (pq.length - 1) / 4))
            this.resize(this.pq.length / 2);

        assert this.isMaxHeap();
        return max;
    }

    private void sink(int k){
        while(2 * k <= this.n){
            int j = 2*k;

            //at this point, we have the left node.
            //if there exists a right node and it is greater than
            //the left node, use that one for the comparison
            if(j < this.n && less(this.pq[j], this.pq[j + 1]))
                j++;

            //j is now the index of the greatest child node.
            //if the value at k is greater than the one at j,
            //it's in the right place, and we're done here
            if(!less(this.pq[k], this.pq[j]))
                break;

            //value at k is not in the right place
            //swap k with j
            T swap = this.pq[k];
            this.pq[k] = this.pq[j];
            this.pq[j] = swap;

            //value in question is now at index j
            k = j;
        }
    }

    public void insert(T x){
        // double the size of the array when full
        if(this.n == this.pq.length - 1)
            this.resize(2 * this.pq.length);

        this.pq[++this.n] = x;
        this.swim(this.n);
        assert this.isMaxHeap();
    }

    private void swim(int k){
        //if the parent (at k/2) is smaller than the value at k,
        //we need to move the value at k up the tree
        while(k > 1 && this.less(this.pq[k/2], this.pq[k])){
            T swap = this.pq[k];
            this.pq[k] = this.pq[k/2];
            this.pq[k/2] = swap;
            k = k/2;
        }
    }

    private boolean isMaxHeap(){
        return this.isMaxHeap(1);
    }

    private boolean isMaxHeap(int k){
        //case statement for when we have reached the end of a
        //particular section of the tree
        if(k > this.n)
            return true;

        //get the child nodes
        int left = 2*k;
        int right = 2*k + 1;

        //if left's index is within the bounds of n
        //and the parent is smaller than it,
        //this tree/subtree is not heap-ordered
        if(left <= this.n && this.less(this.pq[k], this.pq[left]))
            return false;

        //same for right as above for left
        if(right <= this.n && this.less(this.pq[k], this.pq[right]))
            return false;

        //recursive calls to finish checking the rest of the tree
        return this.isMaxHeap(left) && this.isMaxHeap(right);
    }

    private void resize(int capacity){
        T[] temp = (T[]) new Object[capacity];
        for(int i = 1; i <= this.n; i++){
            temp[i] = this.pq[i];
        }

        this.pq = temp;
    }

    //is x less than y?
    private boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
}
