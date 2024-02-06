package xyz.toddlasley.interviews.arraysandstrings;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DownwardRightwardPathsTest {
    @Test
    public void countReturnsNumberOfPaths() {
        int[][] a = {{0, 0}, {0, 0}};
        assertEquals(2, DownwardRightwardPaths.count(a));
        int[][] b = {{0, 0}, {0, 0}, {0, 0}};
        assertEquals(3, DownwardRightwardPaths.count(b));
        int[][] c = {{0, 0, 0}, {0, 0, 0}};
        assertEquals(3, DownwardRightwardPaths.count(c));
        int[][] d = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertEquals(6, DownwardRightwardPaths.count(d));
    }
}