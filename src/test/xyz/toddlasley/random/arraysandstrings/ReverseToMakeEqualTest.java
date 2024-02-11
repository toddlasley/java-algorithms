package xyz.toddlasley.random.arraysandstrings;

import org.junit.Test;
import xyz.toddlasley.random.arraysandstrings.ReverseToMakeEqual;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReverseToMakeEqualTest {
    @Test
    public void shouldDetermineIfArraysCanBeReversedToEqual() {
        assertTrue(ReverseToMakeEqual.areEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 2}));
        assertTrue(ReverseToMakeEqual.areEqual(new int[]{1, 2, 3, 4, 5}, new int[]{1, 5, 4, 3, 2}));
        assertFalse(ReverseToMakeEqual.areEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 3}));
    }
}
