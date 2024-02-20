package me.toddlasley.questions.leetcode.medium.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringNoRepeatedCharsTest {

    @Test
    public void lengthOfLongestSubstringDetectsLongestSubstringWithNoRepeatedCharacters() {
        assertEquals(0, LongestSubstringNoRepeatedChars.lengthOfLongestSubstring(""));
        assertEquals(1, LongestSubstringNoRepeatedChars.lengthOfLongestSubstring(" "));
        assertEquals(1, LongestSubstringNoRepeatedChars.lengthOfLongestSubstring("aaaaaa"));
        assertEquals(2, LongestSubstringNoRepeatedChars.lengthOfLongestSubstring("aaabaaa"));
        assertEquals(5, LongestSubstringNoRepeatedChars.lengthOfLongestSubstring("ckilbkd"));
        assertEquals(4, LongestSubstringNoRepeatedChars.lengthOfLongestSubstring("aaaanew"));
        assertEquals(4, LongestSubstringNoRepeatedChars.lengthOfLongestSubstring("newaaaaa"));
        assertEquals(4, LongestSubstringNoRepeatedChars.lengthOfLongestSubstring("aaaanewaaa"));
    }
}