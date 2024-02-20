package me.toddlasley.datastructures.trees.traversals;

import me.toddlasley.datastructures.trees.TreeNode;

public class PreOrderTraversal {
    public static String traverse(TreeNode root) {
        if (root != null) {
            StringBuilder sb = new StringBuilder();

            traverseHelper(root, sb);

            return sb.toString();
        } else {
            return null;
        }
    }

    private static void traverseHelper(TreeNode node, StringBuilder sb) {
        sb.append(String.format("(%d)", node.data));

        if ( node.left != null ) {
            traverseHelper(node.left, sb);
        }

        if ( node.right != null ) {
            traverseHelper(node.right, sb);
        }
    }
}