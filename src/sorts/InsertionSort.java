// Insertion sort is dependent on order unlike
// selection sort

// Best case (array is already sorted): O(n)
// Worst case (array in reverse order): O(n^2)

package sorts;

public class InsertionSort {
    public static void sort(Comparable[] a){
        int n = a.length;

        for(int i = 0; i < n; i++){
            for(int j = i; j > 0; j--){
                if(less(a[j], a[j - 1])) {
                    Comparable swap = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = swap;
                } else {
                    break;
                }
            }
        }
    }

    //is x less than y?
    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
}
