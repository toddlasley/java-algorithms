package me.toddlasley.questions.leetcode.medium.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;
import static me.toddlasley.questions.leetcode.medium.arraysandstrings.ValidateStackSequences.validateStackSequences;

public class ValidateStackSequencesTest {
    @Test
    public void validateStackSequencesShouldIdentifyValidSequences() {
        assertTrue(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        assertTrue(validateStackSequences(new int[]{0, 1, 2}, new int[]{0, 1, 2}));
        assertTrue(validateStackSequences(new int[]{0, 1, 2}, new int[]{2, 1, 0}));
        assertTrue(validateStackSequences(new int[]{0, 1, 2, 3, 4}, new int[]{1, 0, 4, 3, 2}));
        assertTrue(validateStackSequences(new int[]{0, 1, 2, 3, 4}, new int[]{1, 4, 3, 2, 0}));
        assertTrue(validateStackSequences(new int[]{0, 1, 2, 3, 4}, new int[]{1, 0, 3, 4, 2}));
        assertTrue(validateStackSequences(new int[]{0, 1, 2, 3, 4}, new int[]{1, 0, 3, 2, 4}));

    }

    @Test
    public void validateStackSequencesShouldIdentifyInvalidSequences() {
        assertFalse(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        assertFalse(validateStackSequences(new int[]{0, 1, 2}, new int[]{2, 0, 1}));
        assertFalse(validateStackSequences(new int[]{0, 1, 2, 3, 4}, new int[]{3, 2, 4, 0, 1}));
        assertFalse(validateStackSequences(new int[]{0, 1, 2, 3, 4}, new int[]{4, 2, 3, 1, 0}));
    }
}