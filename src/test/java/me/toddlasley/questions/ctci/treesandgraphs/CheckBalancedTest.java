package me.toddlasley.questions.ctci.treesandgraphs;

import org.junit.Test;

import static me.toddlasley.questions.ctci.treesandgraphs.CheckBalanced.isBalanced;
import static me.toddlasley.questions.ctci.treesandgraphs.CheckBalanced.TreeNode;
import static org.junit.Assert.*;

public class CheckBalancedTest {
    @Test
    public void isBalancedShouldDetermineIfTreeIsBalanced() {
        final TreeNode root0 = new TreeNode(
                0,
                new TreeNode(
                        1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null)
                ),
                new TreeNode(
                        4,
                        new TreeNode(5,null,null),
                        new TreeNode(6,null,null)
                )
        );

        assertTrue(isBalanced(root0));

        final TreeNode root1 = new TreeNode(
                0,
                new TreeNode(
                        1,
                        null,
                        new TreeNode(3, null, null)
                ),
                new TreeNode(
                        4,
                        new TreeNode(5,null,null),
                        new TreeNode(6,null,null)
                )
        );

        assertTrue(isBalanced(root1));

        final TreeNode root2 = new TreeNode(
                0,
                null,
                new TreeNode(
                        4,
                        new TreeNode(5,null,null),
                        new TreeNode(6,null,null)
                )
        );

        assertFalse(isBalanced(root2));

        final TreeNode root3 = new TreeNode(
                0,
                new TreeNode(
                        1,
                        new TreeNode(2,
                                new TreeNode(
                                        7,
                                        null,
                                        new TreeNode(8, null, null)
                                ),
                                null
                        ),
                        new TreeNode(3, null, null)
                ),
                new TreeNode(
                        4,
                        new TreeNode(5,null,null),
                        new TreeNode(6,null,null)
                )
        );

        assertFalse(isBalanced(root3));
    }

}