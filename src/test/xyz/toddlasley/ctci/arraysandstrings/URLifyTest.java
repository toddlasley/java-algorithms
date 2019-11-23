package xyz.toddlasley.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class URLifyTest {

    @Test
    public void replaceSpacesUrlifiesAString() {
        String s1 = "Todd Lasley  ";
        String s2 = "This is a string      ";
        String s3 = "Make it a URL234      ";
        String s4 = "nospaces";

        assertEquals("Todd%20Lasley", URLify.replaceSpaces(s1.toCharArray(), s1.trim().length()));
        assertEquals("This%20is%20a%20string", URLify.replaceSpaces(s2.toCharArray(), s2.trim().length()));
        assertEquals("Make%20it%20a%20URL234", URLify.replaceSpaces(s3.toCharArray(), s3.trim().length()));
        assertEquals("nospaces", URLify.replaceSpaces(s4.toCharArray(), s4.trim().length()));
    }
}