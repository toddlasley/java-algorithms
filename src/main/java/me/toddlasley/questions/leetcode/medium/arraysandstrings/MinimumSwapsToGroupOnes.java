package me.toddlasley.questions.leetcode.medium.arraysandstrings;

public class MinimumSwapsToGroupOnes {
    public static int minSwaps(int[] data) {
        final int[] prefixSum = new int[data.length + 1];

        for (int i = 1; i < prefixSum.length; i++) {
            int j = i - 1;
            prefixSum[i] = data[j] + prefixSum[j];
        }

        final int targetWindow = count(0, data.length - 1, prefixSum);

        int i = 0;
        int j = i + targetWindow - 1;
        int maxOnes = 0;

        while (j < data.length) {
            final int currentOnes = count(i, j, prefixSum);

            maxOnes = Math.max(currentOnes, maxOnes);

            if (maxOnes == targetWindow) {
                break;
            }

            i++;
            j++;
        }

        return targetWindow - maxOnes;
    }

    private static int count(final int from, final int to, final int[] prefixSum) {
        return prefixSum[to + 1] - prefixSum[from];
    }
}
