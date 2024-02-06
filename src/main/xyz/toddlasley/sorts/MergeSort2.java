package xyz.toddlasley.sorts;

public class MergeSort2 {
    public static void sort(final Comparable[] a) {
        final Comparable[] copy = new Comparable[a.length];
        sort(a, copy, 0, a.length - 1);
    }

    private static void sort(final Comparable[] a, final Comparable[] copy, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + ((hi - lo) / 2);
        sort(a, copy, lo, mid);
        sort(a, copy, mid + 1, hi);
        merge(a, copy, lo, mid, hi);
    }

    private static void merge(final Comparable[] a, final Comparable[] copy, int lo, int mid, int hi) {
        for (int c = lo; c <= hi; c++) {
            copy[c] = a[c];
        }

        int i = lo;
        int x = lo;
        int y = mid + 1;

        while (i <= hi) {
            if (x > mid) {
                a[i] = copy[y];
                y++;
            } else if (y > hi) {
                a[i] = copy[x];
                x++;
            } else if (less(copy[y], copy[x])) {
                a[i] = copy[y];
                y++;
            } else {
                a[i] = copy[x];
                x++;
            }

            i++;
        }
    }

    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }
}
