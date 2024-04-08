package me.toddlasley.questions.leetcode.medium.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.*;
import static me.toddlasley.questions.leetcode.medium.treesandgraphs.BinaryTreeLowestCommonAncestorMultipleNodes.lowestCommonAncestor;
import static me.toddlasley.questions.leetcode.medium.treesandgraphs.BinaryTreeLowestCommonAncestorMultipleNodes.TreeNode;

public class BinaryTreeLowestCommonAncestorMultipleNodesTest {
    @Test
    public void lowestCommonAncestorShouldReturnCorrectNode() {
        //        a(3)
        //     /       \
        //   b(5)      c(1)
        //  /    \     /  \
        // d(6) e(2) f(0) g(8)
        //      / \
        //   h(7)  i(4)

        final TreeNode h = new TreeNode(7);
        final TreeNode i = new TreeNode(4);
        final TreeNode d = new TreeNode(6);
        final TreeNode e = new TreeNode(2, h, i);
        final TreeNode f = new TreeNode(0);
        final TreeNode g = new TreeNode(8);
        final TreeNode b = new TreeNode(5, d, e);
        final TreeNode c = new TreeNode(1, f, g);
        final TreeNode a = new TreeNode(3, b, c);

        TreeNode result = lowestCommonAncestor(a, new TreeNode[]{h, i});
        assertEquals(2, result.val);

        result = lowestCommonAncestor(a, new TreeNode[]{c});
        assertEquals(1, result.val);

        result = lowestCommonAncestor(a, new TreeNode[]{d, h, e, i});
        assertEquals(5, result.val);

        result = lowestCommonAncestor(a, new TreeNode[]{d, c, e, i});
        assertEquals(3, result.val);
    }
}