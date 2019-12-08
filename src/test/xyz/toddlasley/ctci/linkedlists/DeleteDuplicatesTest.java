package xyz.toddlasley.ctci.linkedlists;

import org.junit.Test;
import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;

import java.util.HashSet;

import static org.junit.Assert.*;

public class DeleteDuplicatesTest {

    @Test
    public void deleteDuplicatesSuccessfullyDeletesDuplicateNodes() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(1,
                                        new LinkedListNode(4,null)
                                )
                        )
                )
        );

        DeleteDuplicates.deleteDuplicates(head);

        HashSet<Integer> values = new HashSet<>();

        while ( head != null ) {
            if ( values.size() > 1 ) {
                assertFalse(values.contains(head.data));
            }

            values.add(head.data);
            head = head.next;
        }
    }

    @Test
    public void deleteDuplicatesLeavesLinkedListsWithUniqueValuesAlone() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,null)
                                )
                        )
                )
        );

        final int PRIOR_LENGTH = getLinkedListLength(head);

        DeleteDuplicates.deleteDuplicates(head);

        assertEquals(PRIOR_LENGTH, getLinkedListLength(head));
    }

    @Test
    public void deleteDuplicatesNoBufferSuccessfullyDeletesDuplicateNodes() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(1,
                                        new LinkedListNode(4,null)
                                )
                        )
                )
        );

        DeleteDuplicates.deleteDuplicatesNoBuffer(head);

        HashSet<Integer> values = new HashSet<>();

        while ( head != null ) {
            if ( values.size() > 1 ) {
                assertFalse(values.contains(head.data));
            }

            values.add(head.data);
            head = head.next;
        }
    }

    @Test
    public void deleteDuplicatesNoBufferLeavesLinkedListsWithUniqueValuesAlone() {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,null)
                                )
                        )
                )
        );

        final int PRIOR_LENGTH = getLinkedListLength(head);

        DeleteDuplicates.deleteDuplicatesNoBuffer(head);

        assertEquals(PRIOR_LENGTH, getLinkedListLength(head));
    }

    private static int getLinkedListLength(LinkedListNode head){
        int length = 0;

        while ( head != null ) {
            length++;
            head = head.next;
        }

        return length;
    }
}