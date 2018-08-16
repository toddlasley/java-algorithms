//worst case running time with a 3x + 1 incrementing scheme
//is O(n^3/2)
// number of compares with this incrementing is at most, by a small
// multiple of N times the number of increments used?

package sorts;

public class ShellSort {
    public static void sort(Comparable[] a){
        int n = a.length;

        int h = 1;
        //given that the increment sequence is
        //3x + 1, we want h to be less than the length
        // of the array divided by 3 so that the increment
        // sequence is not larger than the array
        while(h < n/3)
            h = 3*h +1; // 1, 4, 13, 40,...

        while (h >= 1){
            //utilizing insertion sort
            //but we aren't incrementing by one
            for(int i = h; i < n; i++){
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    Comparable swap = a[j - h];
                    a[j - h] = a[j];
                    a[j] = swap;
                }
            }

            h = h/3;
        }
    }

    //is x less than y?
    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
}
