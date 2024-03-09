package me.toddlasley.questions.interviews.trees;

// Given a binary tree, determine whether it is symmetrical with respect to its values.

import java.util.Deque;
import java.util.LinkedList;

public class IsSymmetrical {
    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(final int val) {
            this.val = val;
        }

        public TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSymmetrical(final TreeNode root) {
        // recursive calls where each level of the tree is the input
        // technically don't need recursive calls because we can use breadth first search
        // for each level, grab the outer nodes (potentially null) and evaluate
        // could just maintain 2 queues (left and right)

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        final Deque<TreeNode> left = new LinkedList<>();
        left.addLast(root.left);
        final Deque<TreeNode> right = new LinkedList<>();
        right.addLast(root.right);

        while (!left.isEmpty() && !right.isEmpty()) {
            int n = left.size();

            for (int i = 0; i < n; i++) {
                TreeNode l = left.removeFirst();
                TreeNode r = right.removeFirst();

                // l == null and r not
                // r == null and l not
                // neither null and different values

                if (l != r && (l == null || r == null || l.val != r.val)) {
                    return false;
                }

                if (l != null) {
                    left.addLast(l.left);
                    left.addLast(l.right);
                }

                if (r != null) {
                    right.addLast(r.right);
                    right.addLast(r.left);
                }
            }
        }

        return true;

    }
}
