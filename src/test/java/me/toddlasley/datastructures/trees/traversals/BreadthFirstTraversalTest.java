package me.toddlasley.datastructures.trees.traversals;

import org.junit.Test;
import me.toddlasley.datastructures.trees.TreeNode;

import static org.junit.Assert.*;

public class BreadthFirstTraversalTest {

    @Test
    public void printNodesPrintsStringOfBreadthFirstTraversalOnAGivenTree() {
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

        assertEquals("(10)\n(5)(20)\n(3)(7)(15)\n", BreadthFirstTraversal.printNodes(completeTreeRoot));

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

        assertEquals("(10)\n(5)(20)\n(3)(7)(30)\n", BreadthFirstTraversal.printNodes(incompleteTreeRoot));

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

        assertEquals("(10)\n(5)(20)\n(15)(30)\n(12)(18)\n", BreadthFirstTraversal.printNodes(fullTreeRoot));

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

        assertEquals("(10)\n(5)(20)\n(6)(15)(30)\n(12)(18)\n", BreadthFirstTraversal.printNodes(notFullTreeRoot));

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

        assertEquals("(10)\n(5)(20)\n(1)(6)(15)(30)\n", BreadthFirstTraversal.printNodes(perfectTreeRoot));
    }

    @Test
    public void printNodesReturnsRootNodeIfNoOtherNodes() {
        TreeNode root = new TreeNode(2, null, null);

        assertEquals("(2)\n", BreadthFirstTraversal.printNodes(root));
    }

    @Test
    public void printNodesReturnsNullIfNoTree() {
        assertNull(BreadthFirstTraversal.printNodes(null));
    }
}