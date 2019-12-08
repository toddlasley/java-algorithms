//2.1: Write code to remove duplicates from an unsorted linked list.
//Follow-up: How would you solve this problem if a temporary buffer is not allowed;
//Solution: p. 208

package xyz.toddlasley.ctci.linkedlists;
import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;

import java.util.HashSet;

public class DeleteDuplicates {
    public static void deleteDuplicates(LinkedListNode n){
        HashSet<Integer> h = new HashSet<>();

        // keep track of previous node so that we can refer to it when we
        // need to skip/delete the current node
        LinkedListNode previous = null;
        while ( n != null ) {
            if ( h.contains(n.data) ) {
                previous.next = n.next;
            } else {
                h.add(n.data);
                previous = n;
            }

            n = n.next;
        }
    }

    // does the job in O(1) space but O(n^2) time
    public static void deleteDuplicatesNoBuffer(LinkedListNode head){
        LinkedListNode current = head;

        while ( current != null ) {
            LinkedListNode runner = current;

            while ( runner.next != null ) {
                if ( current.data == runner.next.data ) {
                    // skip the runner's next node
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    public static void main(String[] args){
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(1,
                                        new LinkedListNode(4,null)))));

        System.out.println("Before deleteDuplicates()");
        System.out.println(head.toString());
        deleteDuplicates(head);
        System.out.println("After deleteDuplicates()");
        System.out.println(head.toString());

        LinkedListNode head2 = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(1,
                                        new LinkedListNode(4,null)))));

        System.out.println("Before deleteDuplicatesNoBuffer()");
        System.out.println(head2.toString());
        deleteDuplicatesNoBuffer(head2);
        System.out.println("After deleteDuplicatesNoBuffer()");
        System.out.println(head2.toString());
    }
}