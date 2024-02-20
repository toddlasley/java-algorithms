package me.toddlasley.questions.leetcode.medium.arraysandstrings;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumNonUniqueTest {

    @Test
    public void threeSumReturnsAnEmptyListForNoValuesMeetingTheSum() {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        assertTrue(ThreeSumNonUnique.threeSum(array).isEmpty());
    }

    @Test
    public void threeSumReturnsUniqueCombinationsOfValuesThatSumZero() {
        // 0, 0, 0
        // -1, 0, 1
        // -2, 0, 2
        // -4, 0, 4
        // -2, 1, 1
        // 2, 2, -4
        int[] array = { -1, 0, -2, 1, 4, 9, 0, 1, 2, 0, -4, 2, 10, 0 };

        List<List<Integer>> result = ThreeSumNonUnique.threeSum(array);

        assertEquals(6, result.size());
    }
}