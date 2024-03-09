package me.toddlasley.questions.interviews.trees;

import org.junit.Test;

import static org.junit.Assert.*;

import static me.toddlasley.questions.interviews.trees.IsSymmetrical.TreeNode;
import static me.toddlasley.questions.interviews.trees.IsSymmetrical.isSymmetrical;

public class IsSymmetricalTest {

    @Test
    public void isSymmetricalShouldIdentifySymmetricalTreeValues() {
        assertTrue(isSymmetrical(null));
        final TreeNode a = new TreeNode(1);
        assertTrue(isSymmetrical(a));

        a.left = new TreeNode(2);
        a.right = new TreeNode(2);
        assertTrue(isSymmetrical(a));

        a.left.left = new TreeNode(3);
        a.left.right = new TreeNode(4);
        a.right.left = new TreeNode(4);
        a.right.right = new TreeNode(3);
        assertTrue(isSymmetrical(a));

        a.left.left.left = new TreeNode(5);
        a.left.left.right = new TreeNode(6);
        a.left.right.left = new TreeNode(7);
        a.left.right.right = new TreeNode(8);
        a.right.left.left = new TreeNode(8);
        a.right.left.right = new TreeNode(7);
        a.right.right.left = new TreeNode(6);
        a.right.right.right = new TreeNode(5);
        assertTrue(isSymmetrical(a));

        a.left.left.left = null;
        a.right.right.right = null;
        assertTrue(isSymmetrical(a));

        a.left.right.left = null;
        a.right.left.right = null;
        assertTrue(isSymmetrical(a));
    }

    @Test
    public void isSymmetricalShouldIdentifyAsymmetricalTreeValues() {
        final TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        assertFalse(isSymmetrical(a));
        a.right = new TreeNode(2);

        a.left.left = new TreeNode(3);
        a.left.right = new TreeNode(4);
        a.right.left = new TreeNode(4);
        a.right.right = new TreeNode(3);

        a.left.left.left = null;
        a.left.left.right = new TreeNode(6);
        a.left.right.left = new TreeNode(7);
        a.left.right.right = new TreeNode(8);
        a.right.left.left = new TreeNode(8);
        a.right.left.right = new TreeNode(7);
        a.right.right.left = new TreeNode(6);
        a.right.right.right = new TreeNode(5);

        assertFalse(isSymmetrical(a));

        a.left.left.left = new TreeNode(11);
        assertFalse(isSymmetrical(a));
        a.left.left.left.val = 5;
        assertTrue(isSymmetrical(a));
        a.left.right.val = 8;
        assertFalse(isSymmetrical(a));
    }
}