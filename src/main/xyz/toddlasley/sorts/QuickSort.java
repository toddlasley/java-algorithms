// algorithm that identifies a
// pivot value (the first value in a randomly shuffled array)
// to base partitions on and sort recursively

// worst case running time of O(n^2)
// this would only be the case if the shuffle method
// moved everything into descending order, so not likely

// best case running time of O(n lg n)
// this would be the case if the partitions are the same size

package xyz.toddlasley.sorts;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo)
            return;

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;

        while(true){
            // this resulting in false means that we found a value that is greater
            // than the pivot value(the first value in the array/sub-array)
            while(less(a[++i], a[lo])) {
                if (i == hi)
                    break;
            }

            // this resulting in false means that we found a value that is less
            // than the pivot value(the first value in the array/sub-array)
            while(less(a[lo],a[--j])) {
                if (j == lo)
                    break;
            }

            if(i >= j)
                break;

            Comparable swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }

        Comparable swap = a[lo];
        a[lo] = a[j];
        a[j] = swap;

        return j;
    }

    //is x less than y?
    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
}
