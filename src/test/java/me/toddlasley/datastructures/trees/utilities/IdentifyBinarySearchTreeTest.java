package me.toddlasley.datastructures.trees.utilities;

import org.junit.Test;
import me.toddlasley.datastructures.trees.TreeNode;
import me.toddlasley.datastructures.trees.traversals.InOrderTraversal;

import static org.junit.Assert.*;

public class IdentifyBinarySearchTreeTest {

    @Test
    public void isBinarySearchTreeCorrectlyIdentifiesIfGivenTreeIsBST() {
        // a complete binary tree (fills left to right)
        //           10
        //         /   \
        //       5      20
        //      / \     /
        //     3   7   15
        TreeNode completeTreeRoot = new TreeNode(10, null, null);
        completeTreeRoot.left = new TreeNode(5, null, null);
        completeTreeRoot.right = new TreeNode(20, null, null);

        completeTreeRoot.left.left = new TreeNode(3, null, null);
        completeTreeRoot.left.right = new TreeNode(7, null, null);

        completeTreeRoot.right.left = new TreeNode(15, null, null);

        assertTrue(IdentifyBinarySearchTree.isBinarySearchTree(completeTreeRoot));

        // a complete binary tree (fills left to right)
        //           10
        //         /   \
        //       5      20
        //      / \     /
        //     3   7   9

        completeTreeRoot.right.left.data = 9;

        assertFalse(IdentifyBinarySearchTree.isBinarySearchTree(completeTreeRoot));

        // an incomplete binary tree (doesn't fill left to right)
        //           10
        //         /   \
        //       5      20
        //      / \       \
        //     3   7       30
        TreeNode incompleteTreeRoot = new TreeNode(10, null, null);
        incompleteTreeRoot.left = new TreeNode(5, null, null);
        incompleteTreeRoot.right = new TreeNode(20, null, null);

        incompleteTreeRoot.left.left = new TreeNode(3, null, null);
        incompleteTreeRoot.left.right = new TreeNode(7, null, null);

        incompleteTreeRoot.right.right = new TreeNode(30, null, null);

        assertTrue(IdentifyBinarySearchTree.isBinarySearchTree(incompleteTreeRoot));

        // an incomplete binary tree (doesn't fill left to right)
        //           10
        //         /   \
        //       5      20
        //      / \       \
        //     3   4       30

        incompleteTreeRoot.left.right.data = 4;

        assertFalse(IdentifyBinarySearchTree.isBinarySearchTree(incompleteTreeRoot));

        // a full binary tree (no node has one child)
        //      10
        //  /          \
        // 5            20
        //             /  \
        //           15    30
        //          /  \
        //        12    18
        TreeNode fullTreeRoot = new TreeNode(10, null, null);
        fullTreeRoot.left = new TreeNode(5, null, null);
        fullTreeRoot.right = new TreeNode(20, null, null);

        fullTreeRoot.right.left = new TreeNode(15, null, null);
        fullTreeRoot.right.right = new TreeNode(30, null, null);

        fullTreeRoot.right.left.left = new TreeNode(12, null, null);
        fullTreeRoot.right.left.right = new TreeNode(18, null, null);

        assertTrue(IdentifyBinarySearchTree.isBinarySearchTree(fullTreeRoot));

        // a full binary tree (no node has one child)
        //      10
        //  /          \
        // 5            20
        //             /  \
        //            9    30
        //          /  \
        //        12    18

        fullTreeRoot.right.left.data = 9;
        assertFalse(IdentifyBinarySearchTree.isBinarySearchTree(fullTreeRoot));

        // a not full binary tree (at least one node has one child)
        //      10
        //  /          \
        // 5            20
        //  \          /  \
        //   6       15    30
        //          /  \
        //        12    18
        TreeNode notFullTreeRoot = new TreeNode(10, null, null);
        notFullTreeRoot.left = new TreeNode(5, null, null);
        notFullTreeRoot.right = new TreeNode(20, null, null);

        notFullTreeRoot.left.right = new TreeNode(6, null, null);

        notFullTreeRoot.right.left = new TreeNode(15, null, null);
        notFullTreeRoot.right.right = new TreeNode(30, null, null);

        notFullTreeRoot.right.left.left = new TreeNode(12, null, null);
        notFullTreeRoot.right.left.right = new TreeNode(18, null, null);

        assertTrue(IdentifyBinarySearchTree.isBinarySearchTree(notFullTreeRoot));

        // a not full binary tree (at least one node has one child)
        //      10
        //  /          \
        // 5            20
        //  \          /  \
        //   11      15    30
        //          /  \
        //        12    18

        notFullTreeRoot.left.right.data = 11;
        assertFalse(IdentifyBinarySearchTree.isBinarySearchTree(notFullTreeRoot));

        // a perfect (symmetrical) tree
        //      10
        //    /     \
        //   5       20
        //  / \     /  \
        // 1   6  15    30
        TreeNode perfectTreeRoot = new TreeNode(10, null, null);
        perfectTreeRoot.left = new TreeNode(5, null, null);
        perfectTreeRoot.right = new TreeNode(20, null, null);

        perfectTreeRoot.left.left = new TreeNode(1, null, null);
        perfectTreeRoot.left.right = new TreeNode(6, null, null);

        perfectTreeRoot.right.left = new TreeNode(15, null, null);
        perfectTreeRoot.right.right = new TreeNode(30, null, null);

        assertTrue(IdentifyBinarySearchTree.isBinarySearchTree(perfectTreeRoot));

        // a perfect (symmetrical) tree
        //       10
        //     /     \
        //    5       20
        //   / \     /  \
        // 100  6  15    30

        perfectTreeRoot.left.left.data = 100;

        assertFalse(IdentifyBinarySearchTree.isBinarySearchTree(perfectTreeRoot));
    }

    @Test
    public void isBinarySearchTreeReturnsTrueIfOnlyRootNode() {
        TreeNode root = new TreeNode(2, null, null);

        assertTrue(IdentifyBinarySearchTree.isBinarySearchTree(root));
    }

    @Test
    public void isBinarySearchTreeReturnsFalseIfNoTree() {
        assertFalse(IdentifyBinarySearchTree.isBinarySearchTree(null));
    }
}