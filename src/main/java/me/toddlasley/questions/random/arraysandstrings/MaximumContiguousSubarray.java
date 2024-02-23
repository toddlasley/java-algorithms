package me.toddlasley.questions.random.arraysandstrings;

public class MaximumContiguousSubarray {
    public static int calculate(final int[] numbers) {
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int number : numbers) {
            max_ending_here = max_ending_here + number;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
