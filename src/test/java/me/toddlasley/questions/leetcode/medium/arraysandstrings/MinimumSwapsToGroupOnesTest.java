package me.toddlasley.questions.leetcode.medium.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;
import static me.toddlasley.questions.leetcode.medium.arraysandstrings.MinimumSwapsToGroupOnes.minSwaps;
public class MinimumSwapsToGroupOnesTest {
    @Test
    public void minSwapsShouldReturnCorrectCount() {
        assertEquals(0, minSwaps(new int[]{0, 0, 0, 0, 0}));
        assertEquals(0, minSwaps(new int[]{0, 0, 1, 0, 0}));
        assertEquals(1, minSwaps(new int[]{1, 0, 1, 0, 1}));
        assertEquals(3, minSwaps(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1}));
    }
}