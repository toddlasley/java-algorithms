//2.6: Implement a function to check if a linked list is a palindrome.
//Solution: p. 217

package xyz.toddlasley.ctci.linkedlists;

import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(LinkedListNode node){
        Stack<Integer> stack = new Stack<Integer>();
        LinkedListNode slowRunner = node;
        LinkedListNode fastRunner = node;
        while(fastRunner != null && fastRunner.next != null){
            stack.push(slowRunner.data);
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        //if odd number of nodes, move slowRunner once more
        if(fastRunner != null){
            slowRunner = slowRunner.next;
        }

        while(slowRunner != null){
            int top = stack.pop().intValue();

            if(top != slowRunner.data){
                return false;
            }

            slowRunner = slowRunner.next;
        }

        return true;
    }

    public static void main(String[] args){
        LinkedListNode head1 = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(2,
                                        new LinkedListNode(1,null)))));

        System.out.println(String.format("%s is a palindrome: %b", head1.toString(), isPalindrome(head1)));

        LinkedListNode head2 = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,null)))));

        System.out.println(String.format("%s is a palindrome: %b", head2.toString(), isPalindrome(head2)));

        LinkedListNode head3 = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(2,
                                new LinkedListNode(1, null))));

        System.out.println(String.format("%s is a palindrome: %b", head3.toString(), isPalindrome(head3)));
    }
}
