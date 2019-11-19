package xyz.toddlasley.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsUniqueTest {

    @Test
    public void isUnique() {
        assertTrue(IsUnique.isUnique("abcdef"));
        assertTrue(IsUnique.isUnique("abc123"));
        assertFalse(IsUnique.isUnique("abc12a"));
        assertFalse(IsUnique.isUnique("bbbbbbb"));
    }
}