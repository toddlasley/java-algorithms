package me.toddlasley.questions.interviews.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomDictionaryTest {
    @Test
    public void isSortedShouldDetermineIfWordsAreSorted() {
        assertTrue(CustomDictionary.isSorted(new String[]{ "a", "ab", "abc" }, new char[]{ 'a', 'b', 'c' }));
        assertTrue(CustomDictionary.isSorted(new String[]{ "aa", "ab", "ac" }, new char[]{ 'a', 'b', 'c' }));
        assertTrue(CustomDictionary.isSorted(new String[]{ "aa", "ab", "ac" }, new char[]{ 'a', 'b', 'c' }));
        assertTrue(CustomDictionary.isSorted(new String[]{ "aaa", "b", "cab" }, new char[]{ 'a', 'b', 'c' }));
        assertTrue(CustomDictionary.isSorted(new String[]{ "a", "bac", "c" }, new char[]{ 'a', 'b', 'c' }));

        assertFalse(CustomDictionary.isSorted(new String[]{ "a", "ba", "abc" }, new char[]{ 'b', 'a', 'c' }));
        assertFalse(CustomDictionary.isSorted(new String[]{ "aa", "ab", "ac" }, new char[]{ 'b', 'a', 'c' }));
        assertFalse(CustomDictionary.isSorted(new String[]{ "b", "ba", "bb" }, new char[]{ 'b', 'a', 'c' }));
    }

}