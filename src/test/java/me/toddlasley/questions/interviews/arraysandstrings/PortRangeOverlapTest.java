package me.toddlasley.questions.interviews.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;
import static me.toddlasley.questions.interviews.arraysandstrings.PortRangeOverlap.PortRange;
import static me.toddlasley.questions.interviews.arraysandstrings.PortRangeOverlap.hasOverlap;

public class PortRangeOverlapTest {
    @Test
    public void hasOverlapShouldIdentifyPortRangesWithoutOverlap() {
        assertFalse(hasOverlap(new PortRange[] { new PortRange(1, 4), new PortRange(5, 6), new PortRange(7, 10) }));
        assertFalse(hasOverlap(new PortRange[] { new PortRange(7, 10), new PortRange(5, 6), new PortRange(1, 4) }));
        assertFalse(hasOverlap(new PortRange[] { new PortRange(22, 22), new PortRange(1, 3), new PortRange(4, 21) }));
    }

    @Test
    public void hasOverlapShouldIdentifyPortRangesWithOverlap() {
        assertTrue(hasOverlap(new PortRange[] { new PortRange(1, 4), new PortRange(3, 6), new PortRange(7, 10) }));
        assertTrue(hasOverlap(new PortRange[] { new PortRange(7, 10), new PortRange(3, 6), new PortRange(1, 4) }));
        assertTrue(hasOverlap(new PortRange[] { new PortRange(22, 22), new PortRange(1, 3), new PortRange(4, 22) }));
    }
}