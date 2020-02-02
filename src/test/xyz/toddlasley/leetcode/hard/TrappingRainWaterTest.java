package xyz.toddlasley.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrappingRainWaterTest {

    @Test
    public void trapReturnsZeroForArrayLengthLessThanOrEqualToThree() {
        int[] height = { 0, 1, 0 };

        assertEquals(0, TrappingRainWater.trap(height));
    }

    @Test
    public void trapSuccessfullyCalculatesTrappedRainWater() {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        assertEquals(6, TrappingRainWater.trap(height));
    }
}