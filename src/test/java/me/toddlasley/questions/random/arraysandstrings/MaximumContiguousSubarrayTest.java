package me.toddlasley.questions.random.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumContiguousSubarrayTest {
    @Test
    public void calculateShouldFindMaxSum() {
        assertEquals(10, MaximumContiguousSubarray.calculate(new int[]{1, 2, 3, 4}));
        assertEquals(1, MaximumContiguousSubarray.calculate(new int[]{1}));
        assertEquals(6, MaximumContiguousSubarray.calculate(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(23, MaximumContiguousSubarray.calculate(new int[]{5, 4, -1, 7, 8}));
        assertEquals(5, MaximumContiguousSubarray.calculate(new int[]{-2, -2, 5}));
        assertEquals(6, MaximumContiguousSubarray.calculate(new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4}));
    }
}