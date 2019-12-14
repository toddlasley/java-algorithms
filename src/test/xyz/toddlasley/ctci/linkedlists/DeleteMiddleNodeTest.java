package xyz.toddlasley.ctci.linkedlists;

import org.junit.Test;
import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;

import static org.junit.Assert.*;

public class DeleteMiddleNodeTest {

    @Test
    public void deleteMiddleNodeRemovesGivenNodeFromLinkedList() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,null)
                                )
                        )
                )
        );

        LinkedListNode delete = head.next.next;

        DeleteMiddleNode.deleteMiddleNode(delete);

        while ( head != null ) {
            assertNotEquals(3, head.data);
            head = head.next;
        }
    }

    @Test
    public void deleteMiddleNodeLeavesLinkedListAloneIfNodeIsAtTheEnd() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,null)
                                )
                        )
                )
        );

        LinkedListNode delete = head.next.next.next.next;

        DeleteMiddleNode.deleteMiddleNode(delete);

        int length = 0;
        while ( head != null ) {
            length++;
            head = head.next;
        }

        assertEquals(5, length);
    }
}