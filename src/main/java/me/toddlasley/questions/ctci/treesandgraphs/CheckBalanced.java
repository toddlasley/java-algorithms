package me.toddlasley.questions.ctci.treesandgraphs;

public class CheckBalanced {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isBalancedHelper(root, 1) != -1;
        }
    }

    private static int isBalancedHelper(final TreeNode root, int height) {
        if (root == null) {
            return height;
        }

        height++;

        final int leftHeight = isBalancedHelper(root.left, height);

        if (leftHeight == -1) {
            return -1;
        }

        final int rightHeight = isBalancedHelper(root.right, height);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight);
        } else {
            return -1;
        }
    }
}
