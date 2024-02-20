// Given a grid of zeroes and ones, how many unique contiguous areas of ones are there?
// A contiguous area is defined as any series of ones that are adjacent (above/below, left/right)
// but not diagonal

// EX: There are 4 unique contiguous areas in this grid
// 0 1 0 1 0 1
// 0 0 1 1 0 1
// 0 1 0 0 0 1
// 1 1 0 0 0 0

package me.toddlasley.questions.random.arraysandstrings;

import java.util.List;

public class ContiguousAreasInGrid {

    public static int findContiguousAreas(int rows, int columns, List<List<Integer>> grid) {
        int totalContiguousAreas = 0;

        if ( grid != null && rows == grid.size() && columns == grid.get(0).size() ) {
            for ( int r = 0; r < rows; r++ ) {
                for ( int c = 0; c < columns; c++ ) {
                    int value = grid.get(r).get(c);

                    if ( value == 1 ) {
                        totalContiguousAreas++;
                        exploreArea(r, c, rows, columns, grid);
                    }
                }
            }
        }

        return totalContiguousAreas;
    }

    private static void exploreArea( int currentRow, int currentColumn,
                                     int rows, int columns, List<List<Integer>> grid) {
        grid.get(currentRow).set(currentColumn, -1);

        int aboveRow = currentRow - 1;
        int belowRow = currentRow + 1;
        int previousColumn = currentColumn - 1;
        int nextColumn = currentColumn + 1;

        int top = aboveRow >= 0 ? grid.get(aboveRow).get(currentColumn) : 0;

        if ( top == 1 ) {
            exploreArea(aboveRow, currentColumn, rows, columns, grid);
        }

        int below = belowRow < rows ? grid.get(belowRow).get(currentColumn) : 0;

        if ( below == 1 ) {
            exploreArea(belowRow, currentColumn, rows, columns, grid);
        }

        int left = previousColumn >= 0 ? grid.get(currentRow).get(previousColumn) : 0;

        if ( left == 1 ) {
            exploreArea(currentRow, previousColumn, rows, columns, grid);
        }

        int right = nextColumn < columns ? grid.get(currentRow).get(nextColumn) : 0;

        if ( right == 1 ) {
            exploreArea(currentRow, nextColumn, rows, columns, grid);
        }
    }
}
