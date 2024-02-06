package xyz.toddlasley.interviews.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RotationalCipherTest {
    @Test
    public void shouldRotateStrings() {
        assertEquals("Epp-gsrzsCw-3-fi:Epivx5.", RotationalCipher.rotate("All-convoYs-9-be:Alert1.", 4));
        assertEquals("stuvRPQrpq-999.@", RotationalCipher.rotate("abcdZXYzxy-999.@", 200));
    }
}