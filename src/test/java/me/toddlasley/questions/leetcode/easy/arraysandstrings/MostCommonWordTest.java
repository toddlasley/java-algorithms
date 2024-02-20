package me.toddlasley.questions.leetcode.easy.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class MostCommonWordTest {

    @Test
    public void mostCommonWordFindsMostCommonWordThatIsntBanned() {
        String paragraph = "This is a new string. String is good. More STRING";
        String[] banned = {"string"};
        assertEquals("is", MostCommonWord.mostCommonWord(paragraph, banned));

        String[] banned1 = {};
        assertEquals("string", MostCommonWord.mostCommonWord(paragraph, banned1));
    }
}