package xyz.toddlasley.datastructures.graphs.searches;

import xyz.toddlasley.datastructures.graphs.GraphNode;

import java.util.Deque;
import java.util.LinkedList;

public class BreadthFirstSearch {
    public static String search(GraphNode root) {
        StringBuilder sb = new StringBuilder();

        if ( root != null ) {
            Deque<GraphNode> queue = new LinkedList<>();
            root.visited = true;
            queue.addLast(root);

            while ( !queue.isEmpty() ) {
                GraphNode node = queue.removeFirst();
                sb.append(String.format("%d ", node.value));

                for ( GraphNode n : node.adjacent ) {
                    if ( !n.visited ) {
                        n.visited = true;
                        queue.addLast(n);
                    }
                }
            }
        }

        return sb.toString();
    }
}
