package xyz.toddlasley.interviews.arraysandstrings;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseToMakeEqual {
    public static boolean areEqual(int[] a, int[] b) {
        final Deque<Integer> queue = new LinkedList<>();
        final Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < a.length; i++) {
            int valueA = a[i];
            int valueB = b[i];

            if (!queue.isEmpty()) {
                if (valueB == queue.peekFirst() && valueA == stack.peekLast()) {
                    queue.removeFirst();
                    stack.removeLast();

                    while (!queue.isEmpty()) {
                        valueA = queue.removeFirst();
                        valueB = stack.removeFirst();

                        if (valueA != valueB) {
                            return false;
                        }
                    }
                } else {
                    queue.addLast(valueA);
                    stack.addFirst(valueB);
                }
            } else if (valueA != valueB) {
                queue.addLast(valueA);
                stack.addFirst(valueB);
            }
        }

        if (!queue.isEmpty()) {
            return false;
        }

        return true;
    }
}
