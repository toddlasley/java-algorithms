// Given a binary tree, return the zigzag level order traversal of its nodes' values.
// (ie, from left to right, then right to left for the next level and alternate between).
// Original: https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2980/

package xyz.toddlasley.leetcode.medium.treesandgraphs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> level = new LinkedList<>();

        if ( root != null ) {
            level.addLast(root);
        }

        traverseHelper(level, true, result);

        return result;
    }

    private static void traverseHelper(Deque<TreeNode> level, boolean leftToRight, List<List<Integer>> result) {
        if ( level.size() == 0 ) {
            return;
        }

        Deque<TreeNode> nextLevel = new LinkedList<>();

        for ( TreeNode node : level ) {
            if ( node.left != null ) {
                nextLevel.addLast(node.left);
            }

            if ( node.right != null ) {
                nextLevel.addLast(node.right);
            }
        }

        List<Integer> values = new ArrayList<>();

        while ( level.size() != 0 ) {
            if ( leftToRight ) {
                values.add(level.removeFirst().val);
            } else {
                values.add(level.removeLast().val);
            }
        }

        result.add(values);

        traverseHelper(nextLevel, !leftToRight, result);
    }
}
