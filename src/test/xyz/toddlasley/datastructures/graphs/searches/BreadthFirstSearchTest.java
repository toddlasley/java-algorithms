package xyz.toddlasley.datastructures.graphs.searches;

import org.junit.Test;
import xyz.toddlasley.datastructures.graphs.GraphNode;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest {

    @Test
    public void searchReturnsBreadthFirstSearchOfGraph() {
        //   0
        //  /  \
        // 2    1
        //  \ / \ \
        //   3   4 5
        GraphNode g0 = new GraphNode(0);
        GraphNode g1 = new GraphNode(1);
        GraphNode g2 = new GraphNode(2);
        GraphNode g3 = new GraphNode(3);
        GraphNode g4 = new GraphNode(4);
        GraphNode g5 = new GraphNode(5);

        g1.adjacent.add(g3);
        g1.adjacent.add(g4);
        g1.adjacent.add(g5);

        g2.adjacent.add(g3);

        g0.adjacent.add(g1);
        g0.adjacent.add(g2);

        assertEquals("0 1 2 3 4 5 ", BreadthFirstSearch.search(g0));
    }

    @Test
    public void searchReturnsEmptyStringForNullGraph() {
        assertEquals("", BreadthFirstSearch.search(null));
    }
}