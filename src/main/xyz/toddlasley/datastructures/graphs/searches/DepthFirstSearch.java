package xyz.toddlasley.datastructures.graphs.searches;

import xyz.toddlasley.datastructures.graphs.GraphNode;

public class DepthFirstSearch {
    public static String search(GraphNode root) {
        StringBuilder sb = new StringBuilder();

        search(root, sb);

        return sb.toString();
    }

    private static void search(GraphNode node, StringBuilder sb) {
        if ( node != null ) {
            node.visited = true;

            sb.append(String.format("%d ", node.value));

            for ( GraphNode n : node.adjacent ) {
                if ( !n.visited ) {
                    search(n, sb);
                }
            }
        }
    }
}
