package xyz.toddlasley.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZeroMatrixTest {

    @Test
    public void zeroSuccessfullyZeroesMatrixRowsAndColumns() {

        final int ZEROED_ROW = 1;
        final int ZEROED_COLUMN = 2;

        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 12, 14, 0, 5 },
                { 11, 16, 15, 6 },
                { 10, 9, 8, 13 }
        };

        ZeroMatrix.zero(matrix);

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                if ( i == ZEROED_ROW || j == ZEROED_COLUMN ) {
                    assertEquals(0, matrix[i][j]);
                } else {
                    assertTrue(matrix[i][j] != 0);
                }
            }
        }
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