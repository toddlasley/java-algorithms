package me.toddlasley.questions.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    @Test
    public void compressCompressesStringsWhenBeneficial() {
        assertEquals("a3b11c8", StringCompression.compress("aaabbbbbbbbbbbcccccccc"));
        assertEquals("A3B4C5", StringCompression.compress("AAABBBBCCCCC"));

        String s1 = "abcdefg";
        assertEquals(s1, StringCompression.compress("abcdefg"));
    }

    @Test
    public void getCompressedLengthReturnsCompressedLengthOfString() {
        assertEquals(7, StringCompression.getCompressedLength("aaabbbbbbbbbbbcccccccc"));
        assertEquals(6, StringCompression.getCompressedLength("AAABBBBCCCC"));

        String s1 = "abcdefg";
        assertEquals(s1.length() * 2, StringCompression.getCompressedLength("abcdefg"));
    }
}