package me.toddlasley.datastructures.graphs;

import java.util.List;
import java.util.ArrayList;

public class GraphNode {
    public int value;
    public List<GraphNode> adjacent;
    public boolean visited;

    public GraphNode(int value) {
        this.value = value;
        this.adjacent = new ArrayList<>();
        this.visited = false;
    }
}
