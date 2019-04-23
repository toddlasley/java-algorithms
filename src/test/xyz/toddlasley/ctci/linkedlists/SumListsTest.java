package xyz.toddlasley.ctci.linkedlists;

import org.junit.Test;
import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;

import static org.junit.Assert.*;
import static xyz.toddlasley.ctci.linkedlists.SumLists.addLists;

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
}