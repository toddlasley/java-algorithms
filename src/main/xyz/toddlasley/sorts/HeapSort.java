//Heapsort's worst case performance is O(N lg N)

package xyz.toddlasley.sorts;

public class HeapSort {

    public static void sort(Comparable[] pq){
        int n = pq.length;
        //array is in random order.
        //start with smallest parent node and sink that one
        //along with every other parent so that the structure is heap-ordered
        for(int k = n / 2; k >= 1; k--)
            sink(pq, k, n);

        //priority queue is now heap-ordered.
        //swap with "last" element in array and sink the new root.
        while(n > 1){
            Comparable swap = pq[1];
            pq[1] = pq[n];
            pq[n] = swap;
            --n;
            sink(pq, 1, n);
        }
    }

    private static void sink(Comparable[] pq, int k, int n){
        while(2 * k <= n){
            int j = 2*k;

            //at this point, we have the left node.
            //if there exists a right node and it is greater than
            //the left node, use that one for the comparison
            if(j < n && less(pq[j], pq[j + 1]))
                j++;

            //j is now the index of the greatest child node.
            //if the value at k is greater than the one at j,
            //it's in the right place, and we're done here
            if(!less(pq[k], pq[j]))
                break;

            //value at k is not in the right place
            //swap k with j
            Comparable swap = pq[k];
            pq[k] = pq[j];
            pq[j] = swap;

            //value in question is now at index j
            k = j;
        }
    }

    //is x less than y?
    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
}
