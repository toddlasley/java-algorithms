package xyz.toddlasley.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZeroMatrixTest {

    @Test
    public void zeroSuccessfullyZeroesMatrixRowsAndColumns() {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 12, 0, 14, 5 },
                { 11, 16, 15, 6 },
                { 10, 9, 8, 0 }
        };

        ZeroMatrix.zero(matrix);

        assertEquals(0, matrix[0][1]);
        assertEquals(0, matrix[1][1]);
        assertEquals(0, matrix[2][1]);
        assertEquals(0, matrix[3][1]);

        assertEquals(0, matrix[1][0]);
        assertEquals(0, matrix[1][1]);
        assertEquals(0, matrix[1][2]);
        assertEquals(0, matrix[1][3]);

        assertEquals(0, matrix[0][3]);
        assertEquals(0, matrix[1][3]);
        assertEquals(0, matrix[2][3]);
        assertEquals(0, matrix[3][3]);

        assertEquals(0, matrix[3][0]);
        assertEquals(0, matrix[3][1]);
        assertEquals(0, matrix[3][2]);
        assertEquals(0, matrix[3][3]);
    }

    @Test
    public void zeroLeavesMatrixAloneWhereAppropriate() {
        int[][] matrix = {
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 }
        };

        ZeroMatrix.zero(matrix);

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                assertEquals(1, matrix[i][j]);
            }
        }
    }
}