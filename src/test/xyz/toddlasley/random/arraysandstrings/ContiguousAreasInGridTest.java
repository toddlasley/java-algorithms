package xyz.toddlasley.random.arraysandstrings;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ContiguousAreasInGridTest {

    @Test
    public void findContiguousAreasReturnsZeroIfGridIsNullOrRowsOrColumnsDontFitGrid() {
        assertEquals(0, ContiguousAreasInGrid.findContiguousAreas(0, 0, null));

        List<List<Integer>> grid0 = new ArrayList<>();
        grid0.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0, 1)));
        grid0.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1, 0, 1)));
        grid0.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0, 1)));
        grid0.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0, 0, 0)));

        assertEquals(0, ContiguousAreasInGrid.findContiguousAreas(11, grid0.get(0).size(), grid0));
        assertEquals(0, ContiguousAreasInGrid.findContiguousAreas(grid0.size(), 100, grid0));
    }

    @Test
    public void findContiguousAreasReturnsCountOfContiguousAreasInGrid() {
        List<List<Integer>> grid0 = new ArrayList<>();
        grid0.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0, 1)));
        grid0.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1, 0, 1)));
        grid0.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0, 1)));
        grid0.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0, 0, 0)));

        assertEquals(4, ContiguousAreasInGrid.findContiguousAreas(grid0.size(), grid0.get(0).size(), grid0));

        List<List<Integer>> grid1 = new ArrayList<>();
        grid1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0)));
        grid1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0)));
        grid1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0)));
        grid1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0)));

        assertEquals(0, ContiguousAreasInGrid.findContiguousAreas(grid1.size(), grid1.get(0).size(), grid1));

        List<List<Integer>> grid2 = new ArrayList<>();
        grid2.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1)));
        grid2.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1)));
        grid2.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1)));
        grid2.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1)));

        assertEquals(1, ContiguousAreasInGrid.findContiguousAreas(grid2.size(), grid2.get(0).size(), grid2));

        List<List<Integer>> grid3 = new ArrayList<>();
        grid3.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0, 0, 1)));
        grid3.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0, 1, 0)));
        grid3.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0)));
        grid3.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 0, 0, 0)));
        grid3.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0)));
        grid3.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0, 1, 0)));
        grid3.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0, 0, 1)));

        assertEquals(13, ContiguousAreasInGrid.findContiguousAreas(grid3.size(), grid3.get(0).size(), grid3));

        List<List<Integer>> grid4 = new ArrayList<>();
        grid4.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0, 0, 1)));
        grid4.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0, 1, 0)));
        grid4.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0)));
        grid4.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 0, 0, 0)));
        grid4.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0)));
        grid4.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0, 1, 0)));
        grid4.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0, 0, 1)));

        assertEquals(13, ContiguousAreasInGrid.findContiguousAreas(grid4.size(), grid4.get(0).size(), grid4));
    }
}