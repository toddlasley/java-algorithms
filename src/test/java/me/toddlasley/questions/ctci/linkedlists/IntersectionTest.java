package me.toddlasley.questions.ctci.linkedlists;

import org.junit.Test;
import me.toddlasley.questions.ctci.linkedlists.types.IntersectionResult;
import me.toddlasley.questions.ctci.linkedlists.types.LinkedListNode;

import static org.junit.Assert.*;

public class IntersectionTest {

    @Test
    public void findIntersectionSuccessfullyFindsIntersectionForSameSizedLists() {
        LinkedListNode intersection = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3, null)
                )
        );

        LinkedListNode head1 = new LinkedListNode(-1,
                new LinkedListNode(0, intersection)
        );
        LinkedListNode head2 = new LinkedListNode(-1,
                new LinkedListNode(0, intersection)
        );

        assertSame(head1.next.next, Intersection.findIntersection(head1, head2));
    }

    @Test
    public void findIntersectionSuccessfullyFindsIntersectionForDifferentSizedLists() {
        LinkedListNode intersection = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3, null)
                )
        );

        LinkedListNode head1 = new LinkedListNode(-3,
                new LinkedListNode(-2,
                        new LinkedListNode(-1,
                                new LinkedListNode(0, intersection)
                        )
                )
        );
        LinkedListNode head2 = new LinkedListNode(-1,
                new LinkedListNode(0, intersection)
        );

        assertSame(head1.next.next.next.next, Intersection.findIntersection(head1, head2));
    }

    @Test
    public void findIntersectionReturnsNullIfNoIntersection() {
        LinkedListNode head1 = new LinkedListNode(-1,
                new LinkedListNode(0, null)
        );
        LinkedListNode head2 = new LinkedListNode(-1,
                new LinkedListNode(0, null)
        );

        assertNull(Intersection.findIntersection(head1, head2));
    }

    @Test
    public void getLengthAndTailReturnsLengthAndTailOfLinkedList() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3, null)
                )
        );

        IntersectionResult result = Intersection.getLengthAndTail(head);

        assertEquals(3, result.size);
        assertSame(head.next.next, result.tail);
    }

    @Test
    public void getKthNodeTraversesToKthNodeOfLinkedList() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3, null)
                )
        );

        LinkedListNode kNode = Intersection.getKthNode(head, 1);

        assertSame(head.next, kNode);
    }
}