// Insertion sort is dependent on order unlike
// selection sort

// Best case (array is already sorted): O(n)
// Worst case (array in reverse order): O(n^2)

package me.toddlasley.sorts;

public class InsertionSort {
    public static void sort(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--){
                Comparable swap = a[j];
                a[j] = a[j - 1];
                a[j - 1] = swap;
            }
        }
    }

    //is x less than y?
    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
}
