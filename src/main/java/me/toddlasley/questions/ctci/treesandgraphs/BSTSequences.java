package me.toddlasley.questions.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTSequences {
    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(final int data) {
            this.data = data;
        }
    }


    public static List<Deque<Integer>> allSequences(final TreeNode root) {
        final List<Deque<Integer>> result = new ArrayList<>();

        if (root == null) {
            result.add(new LinkedList<>());
            return result;
        }

        final Deque<Integer> current = new LinkedList<>();
        current.addLast(root.data);

        final List<Deque<Integer>> left = allSequences(root.left);
        final List<Deque<Integer>> right = allSequences(root.right);

        for (Deque<Integer> l : left) {
            for (Deque<Integer> r : right) {
                final List<Deque<Integer>> weaved = new ArrayList<>();
                weaveLists(weaved, l, r, current);
                result.addAll(weaved);
            }
        }



        return result;
    }

    private static void weaveLists(final List<Deque<Integer>> result, final Deque<Integer> left, final Deque<Integer> right, final Deque<Integer> prefix) {
        if (left.isEmpty() || right.isEmpty()) {
            final Deque<Integer> newResult = new LinkedList<>(prefix);
            newResult.addAll(left);
            newResult.addAll(right);
            result.add(newResult);
            return;
        }


        prefix.addLast(left.removeFirst());
        weaveLists(result, left, right, prefix);
        left.addFirst(prefix.removeLast());

        prefix.addLast(right.removeFirst());
        weaveLists(result, left, right, prefix);
        right.addFirst(prefix.removeLast());
    }
}

