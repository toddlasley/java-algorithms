package xyz.toddlasley.interviews.heaps;

// You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, for each
// index i (between 0 and n-1, inclusive), output[i] is equal to the product of the three largest elements out
// of arr[0..i] (or equal to -1 if i < 2, as arr[0..i] then includes fewer than three elements).
// Note that the three largest elements used to form any product may have the same values as one another, but
// they must be at different indices in arr.

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindLargestTripleProducts {
    static class IntComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a > b) {
                return -1;
            } else if (b > a) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static int[] findMaxProducts(int[] arr) {

        final int[] result = new int[arr.length];
        final Queue<Integer> heap = new PriorityQueue<>(new IntComparator());

        for (int i = 0; i < arr.length; i++) {
            final int val = arr[i];
            heap.offer(val);

            if (i < 2) {
                result[i] = -1;
            } else {
                final int x = heap.poll();
                final int y = heap.poll();
                final int z = heap.poll();

                result[i] = x * y * z;
                heap.offer(x);
                heap.offer(y);
                heap.offer(z);
            }
        }


        return result;
    }
}
