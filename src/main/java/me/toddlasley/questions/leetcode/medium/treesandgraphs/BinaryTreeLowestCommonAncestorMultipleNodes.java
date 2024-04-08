package me.toddlasley.questions.leetcode.medium.treesandgraphs;

// Given the root of a binary tree and an array of TreeNode objects nodes, return the lowest common ancestor
// (LCA) of all the nodes in nodes. All the nodes will exist in the tree, and all values of the tree's nodes
// are unique.

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BinaryTreeLowestCommonAncestorMultipleNodes {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(final int x) {
            val = x;
        }

        public TreeNode(final int x, final TreeNode left, final TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode[] nodes) {
        final Set<Integer> nodeValues = new HashSet<>();

        for (TreeNode n : nodes) {
            nodeValues.add(n.val);
        }

        final List<Deque<TreeNode>> stacks = new ArrayList<>();
        final Deque<TreeNode> rootStack = new LinkedList<>();
        rootStack.addLast(root);

        lowestCommonAncestorHelper(stacks, nodeValues, rootStack);

        int minSize = stacks.get(0).size();

        for (Deque<TreeNode> s : stacks) {
            if (s.size() < minSize) {
                minSize = s.size();
            }
        }

        for (Deque<TreeNode> s : stacks) {
            if (s.size() > minSize) {
                for (int i = 0; i < s.size() - minSize; i++) {
                    s.removeLast();
                }
            }
        }

        while (!allStacksAtSameNode(stacks)) {
            for (Deque<TreeNode> s : stacks) {
                s.removeLast();
            }
        }

        return stacks.get(0).peekLast();
    }

    private static boolean allStacksAtSameNode(final List<Deque<TreeNode>> stacks) {
        for (int i = 1; i < stacks.size(); i++) {
            if (stacks.get(i).peekLast().val != stacks.get(i - 1).peekLast().val) {
                return false;
            }
        }

        return true;
    }

    private static void lowestCommonAncestorHelper(final List<Deque<TreeNode>> stacks, final Set<Integer> nodeValues, final Deque<TreeNode> current) {
        if (nodeValues.contains(current.peekLast().val)) {
            stacks.add(current);
            return;
        }

        final TreeNode node = current.removeLast();

        if (node.left != null) {
            final Deque<TreeNode> left = new LinkedList<>(current);
            left.addLast(node);
            left.addLast(node.left);
            lowestCommonAncestorHelper(stacks, nodeValues, left);
        }

        if (node.right != null) {
            final Deque<TreeNode> right = new LinkedList<>(current);
            right.addLast(node);
            right.addLast(node.right);
            lowestCommonAncestorHelper(stacks, nodeValues, right);
        }
    }
}
