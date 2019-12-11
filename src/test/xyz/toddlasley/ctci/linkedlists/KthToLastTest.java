package xyz.toddlasley.ctci.linkedlists;

import org.junit.Test;
import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;

import static org.junit.Assert.*;

public class KthToLastTest {

    @Test
    public void returnKthToLastFindsCorrectNode() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,null)
                                )
                        )
                )
        );

        assertEquals(4, KthToLast.returnKthToLast(head, 2).data);
        assertEquals(5, KthToLast.returnKthToLast(head, 1).data);
        assertEquals(1, KthToLast.returnKthToLast(head, 5).data);
    }

    @Test
    public void returnKthToLastReturnsNullIfKIsTooLarge() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,null)
                                )
                        )
                )
        );

        assertNull(KthToLast.returnKthToLast(head, 6));
    }
}