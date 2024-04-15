package me.toddlasley.questions.leetcode.medium.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.*;
import static me.toddlasley.questions.leetcode.medium.treesandgraphs.WallsAndGates.wallsAndGates;

public class WallsAndGatesTest {
    @Test
    public void wallsAndGatesShouldIdentifyDistanceToNearestGate() {
        final int[][] expected = new int[][]{new int[]{3,-1,0,1},new int[]{2,2,1,-1},new int[]{1,-1,2,-1},new int[]{0,-1,3,4}};
        final int[][] result = new int[][]{
                new int[]{2147483647, -1, 0, 2147483647},
                new int[]{2147483647, 2147483647, 2147483647, -1},
                new int[]{2147483647, -1, 2147483647, -1},
                new int[]{0, -1, 2147483647, 2147483647}
        };

        wallsAndGates(result);

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i]);
        }

    }
}