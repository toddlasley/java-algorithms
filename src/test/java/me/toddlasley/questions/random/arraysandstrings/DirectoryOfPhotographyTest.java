package me.toddlasley.questions.random.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectoryOfPhotographyTest {
    @Test
    public void getArtisticPhotographCountShouldReturnCorrectCount() {
        assertEquals(1, DirectoryOfPhotography.getArtisticPhotographCount(5, "APABA", 1, 2));
        assertEquals(0, DirectoryOfPhotography.getArtisticPhotographCount(5, "APABA", 2, 3));
        assertEquals(3, DirectoryOfPhotography.getArtisticPhotographCount(8, ".PBAAP.B", 1, 3));
    }
}