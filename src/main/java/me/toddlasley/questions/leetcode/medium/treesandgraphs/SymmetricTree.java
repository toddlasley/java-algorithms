// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
// Original: https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/507/

package me.toddlasley.questions.leetcode.medium.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isSymmetric(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        return isSymmetric(level);
    }

    private static boolean isSymmetric(List<TreeNode> level) {
        if ( level.size() != 0 ) {
            if ( level.size() != 1 ) {
                int leftIndex = 0;
                int rightIndex = level.size() - 1;

                while ( leftIndex < rightIndex ) {
                    TreeNode left = level.get(leftIndex++);
                    TreeNode right = level.get(rightIndex--);

                    if ( (left != null && right != null && left.val != right.val)
                            || (left == null && right != null)
                            || (right == null && left != null) ) {
                        return false;
                    }
                }

            }

            List<TreeNode> nextLevel = new ArrayList<>();

            for ( TreeNode node : level ) {
                if ( node != null ) {
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }

            return isSymmetric(nextLevel);
        } else {
            return true;
        }
    }
}
