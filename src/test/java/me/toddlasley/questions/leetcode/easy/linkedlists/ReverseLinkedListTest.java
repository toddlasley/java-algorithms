package me.toddlasley.questions.leetcode.easy.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void reverseListConstantSpaceShouldReturnSingleNode() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(0);

        ReverseLinkedList.ListNode result = ReverseLinkedList.reverseListConstantSpace(head);

        assertEquals(0, result.val);
        assertNull(result.next);
    }

    @Test
    public void reverseListConstantSpaceReturnsLinkedListInReverseOrder() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(0);
        ReverseLinkedList.ListNode node1 = new ReverseLinkedList.ListNode(1);
        ReverseLinkedList.ListNode node2 = new ReverseLinkedList.ListNode(2);
        ReverseLinkedList.ListNode node3 = new ReverseLinkedList.ListNode(3);
        ReverseLinkedList.ListNode node4 = new ReverseLinkedList.ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReverseLinkedList.ListNode result = ReverseLinkedList.reverseListConstantSpace(head);

        int expected = 4;
        while ( result != null ) {
            assertEquals(expected--, result.val);
            result = result.next;
        }
    }

    @Test
    public void reverseListConstantSpaceReturnsNullIfLinkedListIsNull() {
        assertNull(ReverseLinkedList.reverseListConstantSpace(null));
    }

    @Test
    public void reverseListReturnsLinkedListInReverseOrder() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(0);
        ReverseLinkedList.ListNode node1 = new ReverseLinkedList.ListNode(1);
        ReverseLinkedList.ListNode node2 = new ReverseLinkedList.ListNode(2);
        ReverseLinkedList.ListNode node3 = new ReverseLinkedList.ListNode(3);
        ReverseLinkedList.ListNode node4 = new ReverseLinkedList.ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReverseLinkedList.ListNode result = ReverseLinkedList.reverseList(head);

        int expected = 4;
        while ( result != null ) {
            assertEquals(expected--, result.val);
            result = result.next;
        }
    }

    @Test
    public void reverseListReturnsNullIfLinkedListIsNull() {
        assertNull(ReverseLinkedList.reverseList(null));
    }
}