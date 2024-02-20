package me.toddlasley.datastructures.trees.traversals;

import me.toddlasley.datastructures.trees.TreeNode;

public class PostOrderTraversal {
    public static String traverse ( TreeNode root ) {
        if ( root != null ) {
            StringBuilder sb = new StringBuilder();

            traverseHelper(root, sb);

            return sb.toString();
        } else {
            return null;
        }
    }

    private static void traverseHelper (TreeNode node, StringBuilder sb) {
        if ( node.left != null ) {
            traverseHelper(node.left, sb);
        }

        if ( node.right != null ) {
            traverseHelper(node.right, sb);
        }

        sb.append(String.format("(%d)", node.data));
    }
}
