package me.toddlasley.questions.random.graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimizingPermutationsTest {
    @Test
    public void minOperationsShouldReturnCorrectValue() {
        assertEquals(1, MinimizingPermutations.minOperations(new int[]{1, 2, 5, 4, 3}));
        assertEquals(2, MinimizingPermutations.minOperations(new int[]{3, 1, 2}));
    }
}