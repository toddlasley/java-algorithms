package xyz.toddlasley.random.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursiveEncryptionTest {
    @Test
    public void shouldEncryptStrings() {
        assertEquals("bac", RecursiveEncryption.encrypt("abc"));
        assertEquals("bacd", RecursiveEncryption.encrypt("abcd"));
        assertEquals("xbacbca", RecursiveEncryption.encrypt("abcxcba"));
        assertEquals("eafcobok", RecursiveEncryption.encrypt("facebook"));
    }
}
