package xyz.toddlasley.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckPermutationTest {

    @Test
    public void isPermutation() {
        assertTrue(CheckPermutation.isPermutation("asdf", "asdf"));
        assertTrue(CheckPermutation.isPermutation("asdf", "fdsa"));
        assertTrue(CheckPermutation.isPermutation("asdf123", "f1ds2a3"));
        assertFalse(CheckPermutation.isPermutation("asdf123", "asdf124"));
        assertFalse(CheckPermutation.isPermutation("asdf123", "asdf124"));
        assertFalse(CheckPermutation.isPermutation("96153515", "asdfwehrf"));
    }
}