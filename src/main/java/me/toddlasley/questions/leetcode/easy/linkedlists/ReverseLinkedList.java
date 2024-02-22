package me.toddlasley.questions.leetcode.easy.linkedlists;
// Reverse a singly linked list.
// Original: https://leetcode.com/explore/interview/card/amazon/77/linked-list/2979/

public class ReverseLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode reverseListConstantSpace(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        head.next = current;
        return prev;
    }

    // 1 -> 2 -> 3 -> 4
    public static ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null ) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next = null;
        setNextNode(node, head);

        return node;
    }

    private static void setNextNode(ListNode head, ListNode node) {
        ListNode runner = head;

        while ( runner.next != null  ) {
            runner = runner.next;
        }

        runner.next = node;
    }
}
