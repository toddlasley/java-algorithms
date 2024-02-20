package me.toddlasley.questions.interviews.arraysandstrings;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CurlyBraceCombinationsTest {

    @Test
    public void getCurlyBraceCombinationsShouldReturnCombinations() {
        CurlyBraceCombinations.getCurlyBraceCombinations(1);
        assertArrayEquals(new String[]{"{}"}, CurlyBraceCombinations.getCurlyBraceCombinations(1).toArray());
        assertEquals(Sets.newHashSet("{}{}", "{{}}"), new HashSet<>(CurlyBraceCombinations.getCurlyBraceCombinations(2)));
        assertEquals(Sets.newHashSet("{}{}{}", "{{{}}}", "{}{{}}", "{{}}{}", "{{}{}}"), new HashSet<>(CurlyBraceCombinations.getCurlyBraceCombinations(3)));
    }

}