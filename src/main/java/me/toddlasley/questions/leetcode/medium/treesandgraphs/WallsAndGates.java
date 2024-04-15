package me.toddlasley.questions.leetcode.medium.treesandgraphs;

import java.util.Deque;
import java.util.LinkedList;

public class WallsAndGates {
    public static void wallsAndGates(int[][] rooms) {
        final int rowSize = rooms.length;
        final int columnSize = rooms[0].length;

        final Deque<int[]> toProcess = new LinkedList<>();

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < columnSize; c++) {
                if (rooms[r][c] == 0) {
                    toProcess.addLast(new int[]{r, c});
                }
            }
        }

        while (!toProcess.isEmpty()) {
            final int[] current = toProcess.removeFirst();
            final int r = current[0];
            final int c = current[1];

            int next = r - 1;
            if (next >= 0 && rooms[next][c] == Integer.MAX_VALUE) {
                rooms[next][c] = rooms[r][c] + 1;
                toProcess.addLast(new int[]{next, c});
            }

            next = r + 1;
            if (next < rowSize && rooms[next][c] == Integer.MAX_VALUE) {
                rooms[next][c] = rooms[r][c] + 1;
                toProcess.addLast(new int[]{next, c});
            }

            next = c - 1;
            if (next >= 0 && rooms[r][next] == Integer.MAX_VALUE) {
                rooms[r][next] = rooms[r][c] + 1;
                toProcess.addLast(new int[]{r, next});
            }

            next = c + 1;
            if (next < columnSize && rooms[r][next] == Integer.MAX_VALUE) {
                rooms[r][next] = rooms[r][c] + 1;
                toProcess.addLast(new int[]{r, next});
            }

        }
    }
}
