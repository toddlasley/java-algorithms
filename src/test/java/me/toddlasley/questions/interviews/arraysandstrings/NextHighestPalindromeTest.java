package me.toddlasley.questions.interviews.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;
import static me.toddlasley.questions.interviews.arraysandstrings.NextHighestPalindrome.nextHighestPalindrome;

public class NextHighestPalindromeTest {
    @Test
    public void nextHighestPalindromeShouldReturnNextHighestPalindrome() {
        assertArrayEquals(new int[]{3}, nextHighestPalindrome(new int[]{2}));
        assertArrayEquals(new int[]{1, 1}, nextHighestPalindrome(new int[]{9}));
        assertArrayEquals(new int[]{3, 3}, nextHighestPalindrome(new int[]{2, 2}));
        assertArrayEquals(new int[]{3, 3}, nextHighestPalindrome(new int[]{2, 3}));
        assertArrayEquals(new int[]{2, 3, 2}, nextHighestPalindrome(new int[]{2, 2, 2}));
        assertArrayEquals(new int[] {1, 2, 4, 2, 1}, nextHighestPalindrome(new int[] {1, 2, 3, 4, 5}));
        assertArrayEquals(new int[] {1, 2, 4, 2, 1}, nextHighestPalindrome(new int[] {1, 2, 3, 2, 5}));
        assertArrayEquals(new int[] {1, 2, 4, 2, 1}, nextHighestPalindrome(new int[] {1, 2, 3, 4, 5}));
        assertArrayEquals(new int[] {5, 4, 3, 4, 5}, nextHighestPalindrome(new int[] {5, 4, 3, 2, 1}));
        assertArrayEquals(new int[] {5, 4, 4, 4, 5}, nextHighestPalindrome(new int[] {5, 4, 3, 9, 1}));
        assertArrayEquals(new int[] {5, 5, 0, 5, 5}, nextHighestPalindrome(new int[] {5, 4, 9, 9, 9}));
        assertArrayEquals(new int[] {1, 2, 4, 4, 2, 1}, nextHighestPalindrome(new int[] {1, 2, 3, 4, 5, 6}));
        assertArrayEquals(new int[] {6, 5, 4, 4, 5, 6}, nextHighestPalindrome(new int[] {6, 5, 4, 3, 2, 1}));
        assertArrayEquals(new int[] {5, 4, 9, 9, 4, 5}, nextHighestPalindrome(new int[] {5, 4, 9, 3, 1, 1}));
        assertArrayEquals(new int[] {5, 4, 4, 4, 4, 5}, nextHighestPalindrome(new int[] {5, 4, 3, 9, 1, 1}));
        assertArrayEquals(new int[] {5, 4, 9, 9, 4, 5}, nextHighestPalindrome(new int[] {5, 4, 9, 8, 1, 1}));
        assertArrayEquals(new int[] {1, 0, 1}, nextHighestPalindrome(new int[] {9, 9}));
        assertArrayEquals(new int[] {1, 0, 0, 1}, nextHighestPalindrome(new int[] {9, 9, 9}));
        assertArrayEquals(new int[] {1, 0, 0, 0, 1}, nextHighestPalindrome(new int[] {9, 9, 9, 9}));
        assertArrayEquals(new int[] {9, 9, 9, 9}, nextHighestPalindrome(new int[] {9, 9, 9, 1}));
        assertArrayEquals(new int[] {2, 0, 0, 2}, nextHighestPalindrome(new int[] {1, 9, 9, 9}));
    }
}