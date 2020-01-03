// Given an array nums of n integers and an integer target, find three integers in nums
// such that the sum is closest to target. Return the sum of the three integers. You may
// assume that each input would have exactly one solution.
// Original: https://leetcode.com/problems/3sum-closest/

package xyz.toddlasley.leetcode.medium.arraysandstrings;

import java.util.Arrays;

public class ClosestThreeSum {
    public static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        Arrays.sort(nums);

        for ( int i = 0; i < nums.length - 2; i++ ) {
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;

            while ( leftIndex < rightIndex ) {
                int currentSum = nums[i] + nums[leftIndex] + nums[rightIndex];

                if ( currentSum < target ) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }

                if ( Math.abs(target - currentSum) < Math.abs(target - result) ) {
                    result = currentSum;
                }
            }
        }

        return result;
    }
}
