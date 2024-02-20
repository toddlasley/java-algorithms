package me.toddlasley.questions.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringRotationTest {

    @Test
    public void rotationCheckSuccessfullyChecksForRotatedStrings() {
        String s1 = "apple";
        String s2 = "pleap";
        String s3 = "dogsandcats";
        String s4 = "catsanddogs";
        String s5 = "iheartjava";
        String s6 = "javaiheart";

        assertTrue(StringRotation.rotationCheck(s1, s2));
        assertFalse(StringRotation.rotationCheck(s3, s4));
        assertTrue(StringRotation.rotationCheck(s5, s6));
    }
}