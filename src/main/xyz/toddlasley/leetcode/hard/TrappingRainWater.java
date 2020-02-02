// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it is able to trap after raining.
// Original: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2975/

package xyz.toddlasley.leetcode.hard;

public class TrappingRainWater {
    public static int trap(int[] height) {
        if ( height.length < 3 ) {
            return 0;
        }

        int result = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while ( leftIndex < rightIndex && height[leftIndex] <= height[leftIndex + 1] ) {
            leftIndex++;
        }

        while ( leftIndex < rightIndex && height[rightIndex] <= height[rightIndex - 1] ) {
            rightIndex--;
        }

        while ( leftIndex < rightIndex ) {
            int left = height[leftIndex];
            int right = height[rightIndex];

            if ( left <= right ) {
                while ( leftIndex < rightIndex && left >= height[++leftIndex] ) {
                    result += left - height[leftIndex];
                }
            } else {
                while ( leftIndex < rightIndex && height[--rightIndex] <= right ) {
                    result += right - height[rightIndex];
                }
            }
        }

        return result;
    }
}
