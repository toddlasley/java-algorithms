// best and worst case running times are
// O(n^2) because the inner for loop is always
// going to continue to search to the end for
// the array for the lowest value

package me.toddlasley.sorts;

public class SelectionSort {

    public static void sort(Comparable[] a){
        int n = a.length;

        for(int i = 0; i < n; i++){
            int min = i;
            for (int j = i + 1; j < n; j++){
                if(less(a[j], a[min]))
                    min = j;
            }

            //at this point, min is the index of the lowest/next lowest
            //value in the array
            //swap the value at that index, with the value that is at index i
            Comparable minValue = a[min];
            a[min] = a[i];
            a[i] = minValue;
        }
    }


    //is x less than y?
    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
}
