package me.toddlasley.questions.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateMatrixTest {

    @Test
    public void rotateSucessfullyRotatesMatrix() {
        int[][] matrix = {
                { 1 , 2, 3, 4 },
                { 12, 13, 14, 5 },
                { 11, 16, 15, 6 },
                { 10, 9, 8, 7}
        };

        RotateMatrix.rotate(matrix);

        assertEquals(10, matrix[0][0]);
        assertEquals(11, matrix[0][1]);
        assertEquals(12, matrix[0][2]);
        assertEquals(1, matrix[0][3]);
        assertEquals(9, matrix[1][0]);
        assertEquals(16, matrix[1][1]);
        assertEquals(13, matrix[1][2]);
        assertEquals(2, matrix[1][3]);
        assertEquals(8, matrix[2][0]);
        assertEquals(15, matrix[2][1]);
        assertEquals(14, matrix[2][2]);
        assertEquals(3, matrix[2][3]);
        assertEquals(7, matrix[3][0]);
        assertEquals(6, matrix[3][1]);
        assertEquals(5, matrix[3][2]);
        assertEquals(4, matrix[3][3]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rotateThrowsErrorForMxNMatrix() {
        int[][] matrix = {
                { 1 , 2, 3, 4 },
                { 12, 13, 14, 5 },
                { 11, 16, 15, 6 }
        };

        RotateMatrix.rotate(matrix);
    }
}