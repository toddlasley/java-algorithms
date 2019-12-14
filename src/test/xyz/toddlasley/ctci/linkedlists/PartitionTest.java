package xyz.toddlasley.ctci.linkedlists;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;


public class PartitionTest {

    @Test
    public void partitionSuccessfullyPartitionsLinkedList() {
        LinkedListNode head = new LinkedListNode(5,
                new LinkedListNode(2,
                        new LinkedListNode(4,
                                new LinkedListNode(7,
                                        new LinkedListNode(9,
                                                new LinkedListNode(1,
                                                        new LinkedListNode(-4,null)
                                                )
                                        )
                                )
                        )
                )
        );

        LinkedListNode partitionedList = Partition.partition(head, 4);

        int index = 0;

        while ( partitionedList != null ) {
            if ( index < 3 ) {
                assertThat( partitionedList.data, lessThan(4));
            } else {
                assertThat( partitionedList.data, greaterThanOrEqualTo(4));
            }

            partitionedList = partitionedList.next;
            index++;
        }
    }
}