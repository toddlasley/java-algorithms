//2.2: Implement an algorithm to find the kth to last element of a singly linked list.
//Solution: p. 211

package xyz.toddlasley.ctci.linkedlists;

import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;

public class KthToLast {
    public static LinkedListNode returnKthToLast(LinkedListNode head, int k){
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // move p1 k nodes ahead of p2
        for ( int i = 0; i < k; i++ ) {
            // if p1 is null, the list is not long enough for the given value of k
            if ( p1 == null ) {
                return null;
            }

            p1 = p1.next;
        }

        while ( p1 != null ) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args){
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(1,
                                        new LinkedListNode(4,null)))));

        System.out.println("Linked list nodes:");
        System.out.println(head.toString());
        LinkedListNode kthToLast = returnKthToLast(head, 2);
        System.out.println("Return the 2nd to last value:");
        System.out.println(kthToLast.data);
    }
}
