package me.toddlasley.questions.ctci.treesandgraphs;

public class MinimalTree {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(final int val, final Node left, final Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Node buildMinimalTree(final int[] numbers) {
        return buildMinimalTreeHelper(numbers, 0, numbers.length - 1);
    }

    private static Node buildMinimalTreeHelper(final int[] numbers, int i, int j) {
        if (i > j) {
            return null;
        }

        int mid = (i + j) / 2;

        final Node current = new Node(numbers[mid], null, null);

        current.left = buildMinimalTreeHelper(numbers, i, mid - 1);
        current.right = buildMinimalTreeHelper(numbers, mid + 1, j);

        return current;
    }
}
