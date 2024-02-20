package me.toddlasley.questions.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PalindromePermutationTest {

    @Test
    public void isPermutationofPalindromeDetectsPalindromePermutations() {
        assertTrue(PalindromePermutation.isPermutationofPalindrome("asdffdsa"));
        assertTrue(PalindromePermutation.isPermutationofPalindrome("asdfdsa"));
        assertTrue(PalindromePermutation.isPermutationofPalindrome("ercrcaa"));

        assertFalse(PalindromePermutation.isPermutationofPalindrome("asdf"));
        assertFalse(PalindromePermutation.isPermutationofPalindrome("asdfdsaq"));
        assertFalse(PalindromePermutation.isPermutationofPalindrome("ercqrcaa"));
    }

    @Test
    public void getCharNumberReturnsNumberGreaterThanNegativeOneForAThroughZ() {
        assertThat( PalindromePermutation.getCharNumber('a'), greaterThan(-1));
        assertThat( PalindromePermutation.getCharNumber('m'), greaterThan(-1));
        assertThat( PalindromePermutation.getCharNumber('z'), greaterThan(-1));
    }

    @Test
    public void getCharNumberReturnsNegativeOneForCharacterNotAThroughZ() {
        assertEquals(-1, PalindromePermutation.getCharNumber('1'));
        assertEquals(-1, PalindromePermutation.getCharNumber('8'));
        assertEquals(-1, PalindromePermutation.getCharNumber(' '));
    }
}