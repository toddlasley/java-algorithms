package me.toddlasley.questions.leetcode.medium.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;
import static me.toddlasley.questions.leetcode.medium.arraysandstrings.MinimumKeyPresses.minimumKeyPresses;

public class MinimumKeyPressesTest {
    @Test
    public void minimumKeyPressesShouldReturnCorrectCount() {
        assertEquals(5, minimumKeyPresses("apple"));
        assertEquals(15, minimumKeyPresses("abcdefghijkl"));
        assertEquals(11, minimumKeyPresses("aaaaaaaaaaa"));
        assertEquals(30, minimumKeyPresses("abcdefghijklabcdefghijkl"));
    }
}