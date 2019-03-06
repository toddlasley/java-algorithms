//"top-down" mergesort
//running time will be proportional to N lg N, no matter the input

package xyz.toddlasley.sorts;

public class MergeSort {

    public static void sort(Comparable[] a){
        Comparable aux[] = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){

        //this case statement will indicate when it is no longer able to split the array
        //or subarrays into halves
        if(hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;

        //recursive calls to cut the array or sub array in halves
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        //copy into aux
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];


        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++){
            if(i > mid)
                a[k] = aux[j++];
            else if(j > hi)
                a[k] = aux[i++];
            else if(less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }

        assert isSorted(a, lo, hi);
    }

    private static boolean isSorted(Comparable[] a){
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi){
        for(int i = lo + 1; i <= hi; i++){
            if(less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    //is x less than y?
    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
}
