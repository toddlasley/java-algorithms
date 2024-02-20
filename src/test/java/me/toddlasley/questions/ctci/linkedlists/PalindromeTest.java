package me.toddlasley.questions.ctci.linkedlists;

import org.junit.Test;
import me.toddlasley.questions.ctci.linkedlists.types.LinkedListNode;

import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void isPalindromeDetectsPalindromeLinkedList() {
        LinkedListNode head1 = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(2,
                                        new LinkedListNode(1,null)
                                )
                        )
                )
        );

        LinkedListNode head2 = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,null)
                                )
                        )
                )
        );

        LinkedListNode head3 = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(2,
                                new LinkedListNode(1, null)
                        )
                )
        );

        assertTrue(Palindrome.isPalindrome(head1));
        assertFalse(Palindrome.isPalindrome(head2));
        assertTrue(Palindrome.isPalindrome(head3));
    }
}