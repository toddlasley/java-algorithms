package me.toddlasley.datastructures.trees.utilities;

import me.toddlasley.datastructures.trees.TreeNode;

public class IdentifyBinarySearchTree {

    public static boolean isBinarySearchTree (TreeNode root) {
        return root != null && isBinarySearchTreeHelper(root, null, null);
    }

    private static boolean isBinarySearchTreeHelper (TreeNode node, TreeNode leftBound, TreeNode rightBound) {
        if ( node == null ) {
            return true;
        }

        if ( leftBound != null && node.data < leftBound.data ) {
            return false;
        }

        if ( rightBound != null && node.data > rightBound.data ) {
            return false;
        }

        return isBinarySearchTreeHelper(node.left, leftBound, node)
                && isBinarySearchTreeHelper(node.right, node, rightBound);
    }
}
