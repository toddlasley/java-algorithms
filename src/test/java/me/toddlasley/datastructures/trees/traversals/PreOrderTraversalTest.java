package me.toddlasley.datastructures.trees.traversals;

import org.junit.Test;
import me.toddlasley.datastructures.trees.TreeNode;

import static org.junit.Assert.*;

public class PreOrderTraversalTest {

    @Test
    public void traversePrintsStringOfPreOrderTraversalOnAGivenTree() {
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

        assertEquals("(10)(5)(3)(7)(20)(15)", PreOrderTraversal.traverse(completeTreeRoot));

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

        assertEquals("(10)(5)(3)(7)(20)(30)", PreOrderTraversal.traverse(incompleteTreeRoot));

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

        assertEquals("(10)(5)(20)(15)(12)(18)(30)", PreOrderTraversal.traverse(fullTreeRoot));

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

        assertEquals("(10)(5)(6)(20)(15)(12)(18)(30)", PreOrderTraversal.traverse(notFullTreeRoot));

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

        assertEquals("(10)(5)(1)(6)(20)(15)(30)", PreOrderTraversal.traverse(perfectTreeRoot));
    }

    @Test
    public void traverseReturnsRootNodeIfNoOtherNodes() {
        TreeNode root = new TreeNode(2, null, null);

        assertEquals("(2)", PreOrderTraversal.traverse(root));
    }

    @Test
    public void traverseReturnsNullIfNoTree() {
        assertNull(PreOrderTraversal.traverse(null));
    }
}