package me.toddlasley.questions.random.linkedlists;

// You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous
// set of even elements, bordered either by either end of the list or an odd element. For example,
// if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
// Then, for each subpart, the order of the elements is reversed. In the example, this would result
// in the new list, [1, 8, 2, 9, 16, 12].

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReverseEvens {
    public static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }

        public List<Integer> toList() {
            final List<Integer> list = new ArrayList<>();
            list.add(data);

            Node runner = next;

            while (runner != null) {
                list.add(runner.data);
                runner = runner.next;
            }

            return list;
        }
    }

    public static Node reverseWithStack(Node head) {

        Node runner = head;
        Node lastOdd = null;
        final Deque<Node> stack = new LinkedList<>();

        while (runner != null) {
            if (runner.data % 2 != 0 && !stack.isEmpty()) {
                if (lastOdd == null) {
                    head = stack.removeLast();
                    lastOdd = head;
                }

                while (!stack.isEmpty()) {
                    lastOdd.next = stack.removeLast();
                    lastOdd = lastOdd.next;
                }

                lastOdd.next = runner;
                lastOdd = lastOdd.next;
            } else if (runner.data % 2 == 0) {
                stack.addLast(runner);
            } else {
                lastOdd = runner;
            }

            runner = runner.next;
        }

        while (!stack.isEmpty()) {
            if (lastOdd == null) {
                head = stack.removeLast();
                lastOdd = head;
            }

            lastOdd.next = stack.removeLast();
            lastOdd = lastOdd.next;
            lastOdd.next = null;
        }

        return head;
    }

    private static Node reverseEvens(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null && current.data % 2 == 0) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }


        head.next = current;
        return prev;
    }

    public static Node reverse(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                prev.next = reverseEvens(current);
            }

            prev = current;
            current = current.next;
        }

        return dummy.next;
    }
}
