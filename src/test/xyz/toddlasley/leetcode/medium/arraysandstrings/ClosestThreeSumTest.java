package xyz.toddlasley.leetcode.medium.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClosestThreeSumTest {

    @Test
    public void threeSumClosestReturnsClosestSumToTargetValue() {
        int[] array = { 4, 3, -2, 0, 5, 3 };

        assertEquals(2, ClosestThreeSum.threeSumClosest(array, 2));
        assertEquals(12, ClosestThreeSum.threeSumClosest(array, 15));
        assertEquals(1, ClosestThreeSum.threeSumClosest(array, 0));
        assertEquals(6, ClosestThreeSum.threeSumClosest(array, 6));
    }
}