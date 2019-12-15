package xyz.toddlasley.ctci.linkedlists;

import org.junit.Test;
import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;
import xyz.toddlasley.ctci.linkedlists.types.PartialSum;

import static org.junit.Assert.*;
import static xyz.toddlasley.ctci.linkedlists.SumLists.*;

public class SumListsTest {

    @Test
    public void addListsReturnsNullWhenLinkedListsAreNull(){
        assertNull(addLists(null, null));
    }

    @Test
    public void addListsReturnsNullWhenLinkedListsAreNullAndCarryIsZero() {
        assertNull(addLists(null, null, 0));
    }

    @Test
    public void addListsReturnsSimpleSum() {
        LinkedListNode l1 = new LinkedListNode(1, new LinkedListNode(3, new LinkedListNode(2, null)));
        LinkedListNode l2 = new LinkedListNode(1, new LinkedListNode(3, new LinkedListNode(2, null)));

        LinkedListNode result = addLists(l1, l2);
        assertEquals(2, result.data);
        assertEquals(6, result.next.data);
        assertEquals(4, result.next.next.data);
    }

    @Test
    public void addListsReturnsSumWithCarry() {
        LinkedListNode l1 = new LinkedListNode(1, new LinkedListNode(3, new LinkedListNode(2, null)));
        LinkedListNode l2 = new LinkedListNode(1, new LinkedListNode(9, new LinkedListNode(2, null)));

        LinkedListNode result = addLists(l1, l2);
        assertEquals(2, result.data);
        assertEquals(2, result.next.data);
        assertEquals(5, result.next.next.data);
    }

    @Test
    public void addListsReturnsSumForDifferentLengthLinkedLists() {
        LinkedListNode l1 = new LinkedListNode(1, new LinkedListNode(3, new LinkedListNode(2, null)));
        LinkedListNode l2 = new LinkedListNode(1, new LinkedListNode(9, null));

        LinkedListNode result = addLists(l1, l2);
        assertEquals(2, result.data);
        assertEquals(2, result.next.data);
        assertEquals(3, result.next.next.data);
    }

    // Follow up problem tests
    @Test
    public void addListsFollowUpReturnsSimpleSum() {
        LinkedListNode l1 = new LinkedListNode(1, new LinkedListNode(3, new LinkedListNode(2, null)));
        LinkedListNode l2 = new LinkedListNode(1, new LinkedListNode(3, new LinkedListNode(2, null)));

        LinkedListNode result = addListsFollowUp(l1, l2);
        assertEquals(2, result.data);
        assertEquals(6, result.next.data);
        assertEquals(4, result.next.next.data);
    }

    @Test
    public void addListsFollowUpReturnsSumWithCarry() {
        LinkedListNode l1 = new LinkedListNode(1, new LinkedListNode(3, new LinkedListNode(2, null)));
        LinkedListNode l2 = new LinkedListNode(1, new LinkedListNode(9, new LinkedListNode(2, null)));

        LinkedListNode result = addListsFollowUp(l1, l2);
        assertEquals(3, result.data);
        assertEquals(2, result.next.data);
        assertEquals(4, result.next.next.data);
    }

    @Test
    public void addListsFollowUpReturnsSumForDifferentLengthLinkedLists() {
        LinkedListNode l1 = new LinkedListNode(1, new LinkedListNode(3, new LinkedListNode(2, null)));
        LinkedListNode l2 = new LinkedListNode(1, new LinkedListNode(9, null));

        LinkedListNode result = addListsFollowUp(l1, l2);
        assertEquals(1, result.data);
        assertEquals(5, result.next.data);
        assertEquals(1, result.next.next.data);
    }

    @Test
    public void addListsHelperReturnsPartialSumFor2Nodes() {
        LinkedListNode l1 = new LinkedListNode(1, null);
        LinkedListNode l2 = new LinkedListNode(4, null);

        PartialSum sum = addListsHelper(l1, l2);

        assertEquals(0, sum.carry);
        assertEquals(5, sum.sum.data);
    }

    @Test
    public void addListsHelperReturnsPartialSumFor2NodesWithCarry() {
        LinkedListNode l1 = new LinkedListNode(1, null);
        LinkedListNode l2 = new LinkedListNode(9, null);

        PartialSum sum = addListsHelper(l1, l2);

        assertEquals(1, sum.carry);
        assertEquals(0, sum.sum.data);
    }

    @Test
    public void padListAddsAppropriateNumberOfZeroesToList() {
        LinkedListNode head = new LinkedListNode(1, null);

        LinkedListNode padded = padList(head, 3);

        int index = 0;
        while ( padded != null ) {
            if ( index < 3 ) {
                assertEquals(0, padded.data);
            } else {
                assertNotEquals(0, padded.data);
            }

            padded = padded.next;
            index++;
        }
    }

    @Test
    public void insertBeforeAddsValueToFrontOfNode() {
        LinkedListNode head = new LinkedListNode(1, null);

        LinkedListNode inserted = insertBefore(head, 2);

        assertEquals(2, inserted.data);
        assertEquals(1, inserted.next.data);
    }
}