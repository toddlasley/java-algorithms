package me.toddlasley.questions.leetcode.medium.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class CopyListWithRandomPointerTest {

    @Test
    public void copyRandomListReturnsNullIfListIsNull() {
        assertNull(CopyListWithRandomPointer.copyRandomList(null));
    }

    @Test
    public void copyRandomListReturnsDeepCopyOfList() {
        CopyListWithRandomPointer.Node node = new CopyListWithRandomPointer.Node(0);
        CopyListWithRandomPointer.Node node1 = new CopyListWithRandomPointer.Node(1);
        CopyListWithRandomPointer.Node node2 = new CopyListWithRandomPointer.Node(2);
        CopyListWithRandomPointer.Node node3 = new CopyListWithRandomPointer.Node(3);
        CopyListWithRandomPointer.Node node4 = new CopyListWithRandomPointer.Node(4);
        CopyListWithRandomPointer.Node node5 = new CopyListWithRandomPointer.Node(5);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node.random = node2;
        node2.random = node1;
        node3.random = node;
        node5.random = node3;

        CopyListWithRandomPointer.Node copy = CopyListWithRandomPointer.copyRandomList(node);

        CopyListWithRandomPointer.Node runner = node;
        CopyListWithRandomPointer.Node copyRunner = copy;

        for ( int i = 0; i < 6; i++ ) {
            assertEquals(i, copyRunner.val);
            assertNotEquals(runner, copyRunner);

            runner = runner.next;
            copyRunner = copyRunner.next;
        }

        assertEquals(copy.random, copy.next.next);
        assertNull(copy.next.random);
        assertEquals(copy.next.next.random, copy.next);
        assertEquals(copy.next.next.next.random, copy);
        assertNull(copy.next.next.next.next.random);
        assertEquals(copy.next.next.next.next.next.random, copy.next.next.next);
    }
}