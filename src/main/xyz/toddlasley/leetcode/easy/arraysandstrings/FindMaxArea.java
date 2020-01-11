// Given n non-negative integers a1, a2, ..., an , where each represents a point
// at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is
// at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the
// container contains the most water.
// Note: You may not slant the container and n is at least 2.

package xyz.toddlasley.leetcode.easy.arraysandstrings;

public class FindMaxArea {
    public static int maxArea(int[] height) {
        int result = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while ( leftIndex < rightIndex ) {
            int area = calculateArea(leftIndex, rightIndex, height);

            if ( area > result ) {
                result = area;
            }

            if ( height[leftIndex] < height[rightIndex] ) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return result;
    }

    private static int calculateArea(int leftIndex, int rightIndex, int[] height){
        return height[leftIndex] < height[rightIndex]
                ? (rightIndex - leftIndex) * height[leftIndex]
                : (rightIndex - leftIndex) * height[rightIndex];
    }
}
