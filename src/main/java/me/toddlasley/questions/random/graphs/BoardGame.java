package me.toddlasley.questions.random.graphs;

// Given an array of integers that represent spaces on a board, and an integer that represents
// the maximum amount of spaces that you can move. Determine if the game can be completed

import java.util.Deque;
import java.util.LinkedList;

public class BoardGame {
    public static boolean canComplete(final int[] board, final int d) {
        final Deque<Integer> moves = new LinkedList<>();
        moves.addLast(0);

        final int end = board.length - 1;

        while (!moves.isEmpty()) {
            final int n = moves.size();

            for (int i = 0; i < n; i++) {
                final int position = moves.removeFirst();

                for (int j = 1; j <= d; j++) {
                    final int current = position + j;

                    if (current == end) {
                        return true;
                    } else if (current < end && board[current] != 0) {
                        moves.addLast(current);
                    }
                }
            }
        }

        return false;
    }

    public static int movesToComplete(final int[] board, final int d) {
        final Deque<Integer> moves = new LinkedList<>();
        moves.addLast(0);

        final int end = board.length - 1;
        int moveCount = 0;

        while (!moves.isEmpty()) {
            final int n = moves.size();

            for (int i = 0; i < n; i++) {
                final int position = moves.removeFirst();

                for (int j = 1; j <= d; j++) {
                    final int current = position + j;

                    if (current == end) {
                        return moveCount + 1;
                    } else if (current < end && board[current] != 0) {
                        moves.addLast(current);
                    }
                }
            }

            moveCount++;
        }

        return -1;
    }
}
