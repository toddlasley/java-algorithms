package xyz.toddlasley.datastructures.trees.traversals;

import xyz.toddlasley.datastructures.trees.TreeNode;

public class InOrderTraversal {

    public static String traverse ( TreeNode root ) {
        if ( root != null ) {
            StringBuilder sb = new StringBuilder();

            traverseHelper(root, sb);

            return sb.toString();
        } else {
            return null;
        }
    }

    private static void traverseHelper ( TreeNode node, StringBuilder sb ) {
        if ( node.left != null ) {
            traverseHelper( node.left, sb );
        }

        sb.append(String.format("(%d)", node.data));

        if ( node.right != null ) {
            traverseHelper(node.right, sb);
        }
    }
}
