package xyz.toddlasley.leetcode.medium.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberLetterCombinationsTest {

    @Test
    public void letterCombinationsReturnsEmptyListForEmptyString() {
        assertEquals(0, PhoneNumberLetterCombinations.letterCombinations("").size());
    }

    @Test
    public void letterCombinationsReturnsCorrectNumberOfCombinations() {
        assertEquals(9, PhoneNumberLetterCombinations.letterCombinations("23").size());
        assertEquals(27, PhoneNumberLetterCombinations.letterCombinations("233").size());
        assertEquals(108, PhoneNumberLetterCombinations.letterCombinations("2339").size());
    }
}