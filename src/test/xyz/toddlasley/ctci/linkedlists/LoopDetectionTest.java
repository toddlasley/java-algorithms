package xyz.toddlasley.ctci.linkedlists;

import org.junit.Test;
import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;

import static org.junit.Assert.*;

public class LoopDetectionTest {

    @Test
    public void findBeginningSuccessfullyDetectsStartOfLoop() {
        LinkedListNode loopHead = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,
                                                new LinkedListNode(6,
                                                        new LinkedListNode(7,null)
                                                )
                                        )
                                )
                        )
                )
        );

        loopHead.next.next.next.next.next.next = loopHead;

        assertSame(loopHead, LoopDetection.findBeginning(loopHead));

        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3, loopHead)
                )
        );

        assertSame(loopHead, LoopDetection.findBeginning(head));
    }

    @Test
    public void findBeginningReturnsNullIfNoLoop() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,
                                                new LinkedListNode(6,
                                                        new LinkedListNode(7,null)
                                                )
                                        )
                                )
                        )
                )
        );

        assertNull(LoopDetection.findBeginning(head));
    }
}