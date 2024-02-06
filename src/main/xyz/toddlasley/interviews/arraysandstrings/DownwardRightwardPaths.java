// Given an M x N matrix, return the number of unique paths one could take when trying to
// navigate from the top left position to the bottom right position while only being able
// to move downward and to the right.

package xyz.toddlasley.interviews.arraysandstrings;

public class DownwardRightwardPaths {
    public static int count(final int[][] m) {
        int rowLength = m.length;
        int columnLength = m[0].length;

        return countHelper(m, 0, 0, rowLength, columnLength);
    }

    private static int countHelper(final int[][] m, int r, int c, int rowLength, int columnLength) {
        if (r >= rowLength || c >= columnLength) {
            return 0;
        } else if (r == rowLength - 1 && c == columnLength - 1) {
            return 1;
        } else {
            return countHelper(m, r + 1, c, rowLength, columnLength) + countHelper(m, r, c + 1, rowLength, columnLength);
        }
    }
}
