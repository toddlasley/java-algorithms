package me.toddlasley.questions.leetcode.easy.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMaxAreaTest {

    @Test
    public void maxAreaFindsMaxAreaAmongHeights() {
        int[] heights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        assertEquals(25, FindMaxArea.maxArea(heights));

        int[] heights1 = { 1, 2, 9, 4, 5, 6, 7, 8, 10 };

        assertEquals(54, FindMaxArea.maxArea(heights1));
    }
}