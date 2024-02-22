package me.toddlasley.questions.random.linkedlists;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReverseOrderTest {

    @Test
    public void reverseShouldReverseOddSubparts() {
        assertEquals(
                Lists.newArrayList(1, 8, 2, 9, 16, 12),
                ReverseOrder.reverse(buildLinkedList(Lists.newArrayList(1, 2, 8, 9, 12, 16))).toList()
        );
        assertEquals(
                Lists.newArrayList(16, 12, 10, 8, 2),
                ReverseOrder.reverse(buildLinkedList(Lists.newArrayList(2, 8, 10, 12, 16))).toList()
        );
        assertEquals(
                Lists.newArrayList(4, 2, 1, 3, 8, 6, 9),
                ReverseOrder.reverse(buildLinkedList(Lists.newArrayList(2, 4, 1, 3, 6, 8, 9))).toList()
        );
        assertEquals(
                Lists.newArrayList(1, 3, 5, 7, 9),
                ReverseOrder.reverse(buildLinkedList(Lists.newArrayList(1, 3, 5, 7, 9))).toList()
        );
        assertEquals(
                Lists.newArrayList(4, 2, 1, 3, 8, 6, 9, 12, 10),
                ReverseOrder.reverse(buildLinkedList(Lists.newArrayList(2, 4, 1, 3, 6, 8, 9, 10, 12))).toList()
        );
    }

    @Test
    public void reverseWithStackShouldReverseOddSubparts() {
        assertEquals(
                Lists.newArrayList(1, 8, 2, 9, 16, 12),
                ReverseOrder.reverseWithStack(buildLinkedList(Lists.newArrayList(1, 2, 8, 9, 12, 16))).toList()
        );
        assertEquals(
                Lists.newArrayList(16, 12, 10, 8, 2),
                ReverseOrder.reverseWithStack(buildLinkedList(Lists.newArrayList(2, 8, 10, 12, 16))).toList()
        );
        assertEquals(
                Lists.newArrayList(4, 2, 1, 3, 8, 6, 9),
                ReverseOrder.reverseWithStack(buildLinkedList(Lists.newArrayList(2, 4, 1, 3, 6, 8, 9))).toList()
        );
        assertEquals(
                Lists.newArrayList(1, 3, 5, 7, 9),
                ReverseOrder.reverseWithStack(buildLinkedList(Lists.newArrayList(1, 3, 5, 7, 9))).toList()
        );
        assertEquals(
                Lists.newArrayList(4, 2, 1, 3, 8, 6, 9, 12, 10),
                ReverseOrder.reverseWithStack(buildLinkedList(Lists.newArrayList(2, 4, 1, 3, 6, 8, 9, 10, 12))).toList()
        );
    }

    private static ReverseOrder.Node buildLinkedList(final List<Integer> list) {
        final ReverseOrder.Node head = new ReverseOrder.Node(list.get(0));
        ReverseOrder.Node runner = head;

        for (int i = 1; i < list.size(); i++) {
            runner.next = new ReverseOrder.Node(list.get(i));
            runner = runner.next;
        }

        return head;
    }
}