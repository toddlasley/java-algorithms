// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
// The solution set must not contain duplicate triplets.
// Original problem: https://leetcode.com/problems/3sum/

package me.toddlasley.questions.leetcode.medium.arraysandstrings;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumNonUnique {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for ( int i = 0; i < nums.length - 2; i++ ) {
            if ( i == 0 || ( i > 0 && nums[i] != nums[i - 1] ) ) {
                // implementing a partial bi-directional search on a sorted array
                // rather than going through the hassle of managing a HashSet or something like that
                int leftIndex = i + 1;
                int rightIndex = nums.length - 1;

                while ( leftIndex < rightIndex ) {
                    // 3 checks:
                    //   - check for a sum of zero
                    //   - check if the sum is less than zero. If so, increment
                    //     the leftIndex in the hopes of finding a bigger value
                    //     to meet the sum
                    //   - else case is if the sum is greater than zero, in which
                    //     we decrement the rightIndex using similar logic from
                    //     the point above
                    if ( nums[i] + nums[leftIndex] + nums[rightIndex] == 0 ) {
                        List<Integer> newList = new ArrayList<>();
                        newList.add(nums[i]);
                        newList.add(nums[leftIndex]);
                        newList.add(nums[rightIndex]);

                        result.add(newList);

                        // the following while loops are what prevent us from gathering duplicate triplets
                        // any duplicate values that we skip here have likely already been used if they are
                        // they are needed at all
                        while ( leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1] ) {
                            leftIndex++;
                        }

                        while ( leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1] ) {
                            rightIndex--;
                        }

                        leftIndex++;
                        rightIndex--;

                    } else if ( nums[i] + nums[leftIndex] + nums[rightIndex] < 0 ) {
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }

                }
            }
        }

        return result;
    }
}
