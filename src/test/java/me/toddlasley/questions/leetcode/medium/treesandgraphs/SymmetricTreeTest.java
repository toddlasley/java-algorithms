package me.toddlasley.questions.leetcode.medium.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricTreeTest {

    @Test
    public void isSymmetricReturnsTrueForNullTree() {
        assertTrue(SymmetricTree.isSymmetric(null));
    }

    @Test
    public void isSymmetricReturnsTrueForSingleNodeTree() {
        assertTrue(SymmetricTree.isSymmetric(new SymmetricTree.TreeNode(1)));
    }

    @Test
    public void isSymmetricAppropriatelyIdentfiesSymmetricTrees() {
        SymmetricTree.TreeNode root = new SymmetricTree.TreeNode(1);
        root.left = new SymmetricTree.TreeNode(2);
        root.right = new SymmetricTree.TreeNode(2);
        root.left.left = new SymmetricTree.TreeNode(3);
        root.left.right = new SymmetricTree.TreeNode(3);
        root.right.left = new SymmetricTree.TreeNode(3);
        root.right.right = new SymmetricTree.TreeNode(3);
        assertTrue(SymmetricTree.isSymmetric(root));

        SymmetricTree.TreeNode root1 = new SymmetricTree.TreeNode(1);
        root1.left = new SymmetricTree.TreeNode(2);
        root1.right = new SymmetricTree.TreeNode(2);
        root1.left.left = new SymmetricTree.TreeNode(3);
        root1.left.right = new SymmetricTree.TreeNode(3);
        root1.right.left = new SymmetricTree.TreeNode(4);
        root1.right.right = new SymmetricTree.TreeNode(3);
        assertFalse(SymmetricTree.isSymmetric(root1));
    }
}