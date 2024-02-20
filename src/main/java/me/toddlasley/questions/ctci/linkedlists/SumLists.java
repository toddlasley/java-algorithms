// 2.5: You have two numbers represent by a linked list, where each node contains a single digit.
// The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a
// function that adds the two numbers and returns the sum as a linked list.
// Follow up: Suppose the digits are stored in forward order. Repeat the above problem.
// Solution: p. 214

package me.toddlasley.questions.ctci.linkedlists;

import me.toddlasley.questions.ctci.linkedlists.types.LinkedListNode;
import me.toddlasley.questions.ctci.linkedlists.types.PartialSum;

public class SumLists {
    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        return addLists(l1, l2, 0);
    }

    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if( l1 == null && l2 == null && carry == 0 ) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int value = carry;

        if ( l1 != null ) {
            value += l1.data;
        }

        if ( l2 != null ) {
            value += l2.data;
        }

        result.data = value % 10;

        if ( l1 != null || l2 != null ) {
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);

            result.setNext(more);
        }

        return result;
    }

    // Follow up solution
    public static LinkedListNode addListsFollowUp(LinkedListNode l1, LinkedListNode l2) {
        int length1 = l1.length();
        int length2 = l2.length();

        // pad the shorter length linked list with zeroes
        if( length1 < length2 ) {
            l1 = padList(l1, length2 - length1);
        } else if ( length2 < length1 ) {
            l2 = padList(l2, length1 - length2);
        }

        // hand off to this method since padding won't be needed from
        // here on out
        PartialSum sum = addListsHelper(l1, l2);

        if ( sum.carry == 0){
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    public static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2){
        if ( l1 == null && l2 == null ) {
            return new PartialSum();
        }

        PartialSum sum = addListsHelper(l1.next, l2.next);

        int val = sum.carry + l1.data + l2.data;

        LinkedListNode fullResult = insertBefore(sum.sum, val % 10);

        sum.sum = fullResult;
        sum.carry = val / 10;

        return sum;
    }

    public static LinkedListNode padList(LinkedListNode l, int padding){
        LinkedListNode head = l;

        for ( int i = 0; i < padding; i++ ) {
            head = insertBefore(head, 0);
        }

        return head;
    }

    public static LinkedListNode insertBefore(LinkedListNode l, int data){
        LinkedListNode node = new LinkedListNode(data, null);

        if ( l != null ) {
            node.next = l;
        }

        return node;
    }

    public static void main(String[] args){
        System.out.println(".addLists() results:");

        LinkedListNode l1 = new LinkedListNode(5,
                new LinkedListNode(2,
                        new LinkedListNode(4, null)));

        LinkedListNode l2 = new LinkedListNode(9,
                new LinkedListNode(5,
                        new LinkedListNode(1, null)));

        System.out.println(String.format("%s +  %s =  %s", l1.toString(), l2.toString(), addLists(l1, l2).toString()));

        LinkedListNode l3 = new LinkedListNode(3,
                new LinkedListNode(2,
                        new LinkedListNode(1, null)));

        LinkedListNode l4 = new LinkedListNode(1,
                new LinkedListNode(1, null));

        System.out.println(String.format("%s +  %s =  %s", l3.toString(), l4.toString(), addLists(l3, l4).toString()));

        System.out.println(".addListsReverse() results (follow up question):");
        LinkedListNode l5 = new LinkedListNode(3,
                new LinkedListNode(2,
                        new LinkedListNode(1, null)));

        LinkedListNode l6 = new LinkedListNode(1,
                new LinkedListNode(1, null));

        System.out.println(String.format("%s +  %s =  %s", l5.toString(), l6.toString(), addListsFollowUp(l5, l6).toString()));

        LinkedListNode l7 = new LinkedListNode(5,
                new LinkedListNode(2,
                        new LinkedListNode(4, null)));

        LinkedListNode l8 = new LinkedListNode(9,
                new LinkedListNode(5,
                        new LinkedListNode(1, null)));

        System.out.println(String.format("%s +  %s =  %s", l7.toString(), l8.toString(), addListsFollowUp(l7, l8).toString()));
    }
}
