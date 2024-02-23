package me.toddlasley.questions.random.graphs;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinimizingPermutations {
    public static int minOperations(int[] arr) {
        final Deque<int[]> queue = new LinkedList<>();
        final Set<String> seen = new HashSet<>();
        final int[] target = new int[arr.length];
        int count = 0;

        for (int i = 1; i <= arr.length; i++) {
            target[i - 1] = i;
        }

        queue.addLast(arr);
        seen.add(Arrays.toString(arr));

        while (!queue.isEmpty()) {
            final int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                final int[] current = queue.removeFirst();

                if (Arrays.equals(current, target)) {
                    return count;
                }

                for (int j = 0; j < arr.length; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        final int[] nextPermutation = current.clone();

                        int x = j;
                        int y = k;

                        while (x < y) {
                            final int temp = nextPermutation[x];
                            nextPermutation[x] = nextPermutation[y];
                            nextPermutation[y] = temp;
                            x++;
                            y--;
                        }

                        final String nextPermutationString = Arrays.toString(nextPermutation);
                        if (!seen.contains(nextPermutationString)) {
                            seen.add(nextPermutationString);
                            queue.addLast(nextPermutation);
                        }
                    }
                }
            }
            count++;
        }

        return count;
    }
}
