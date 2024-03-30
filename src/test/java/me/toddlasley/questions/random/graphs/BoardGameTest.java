package me.toddlasley.questions.random.graphs;

import org.junit.Test;

import static me.toddlasley.questions.random.graphs.BoardGame.movesToComplete;
import static org.junit.Assert.*;
import static me.toddlasley.questions.random.graphs.BoardGame.canComplete;

public class BoardGameTest {
    @Test
    public void canCompleteShouldDetermineIfGameCannotBeCompleted() {
        assertFalse(canComplete(new int[]{1, 0, 0, 0, 1}, 3));
        assertFalse(canComplete(new int[]{1, 0, 0, 0, 1}, 0));
        assertFalse(canComplete(new int[]{1, 0, 1, 0, 1}, 1));
        assertFalse(canComplete(new int[]{1, 1, 1, 1, 1}, 0));
    }

    @Test
    public void canCompleteShouldDetermineIfGameCanBeCompleted() {
        assertTrue(canComplete(new int[]{1, 0, 1, 0, 1}, 2));
        assertTrue(canComplete(new int[]{1, 0, 0, 0, 1}, 4));
    }

    @Test
    public void movesToCompleteShouldReturnNegativeOneIfImpossibleToComplete() {
        assertEquals(-1, movesToComplete(new int[]{1, 0, 0, 0, 1}, 3));
        assertEquals(-1, movesToComplete(new int[]{1, 0, 0, 0, 1}, 0));
        assertEquals(-1, movesToComplete(new int[]{1, 0, 1, 0, 1}, 1));
        assertEquals(-1, movesToComplete(new int[]{1, 1, 1, 1, 1}, 0));
    }

    @Test
    public void movesToCompleteShouldReturnMinimumMovesToComplete() {
        assertEquals(2, movesToComplete(new int[]{1, 0, 1, 0, 1}, 2));
        assertEquals(1, movesToComplete(new int[]{1, 0, 0, 0, 1}, 4));
        assertEquals(2, movesToComplete(new int[]{1, 0, 0, 0, 1, 0, 1}, 4));
        assertEquals(3, movesToComplete(new int[]{1, 1, 0, 0, 1, 0, 1}, 3));
    }
}