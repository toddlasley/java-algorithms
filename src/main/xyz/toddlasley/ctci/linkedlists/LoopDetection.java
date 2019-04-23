//2.8: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
//Solution: p. 223

package xyz.toddlasley.ctci.linkedlists;

import xyz.toddlasley.ctci.linkedlists.types.LinkedListNode;

public class LoopDetection {
    public static LinkedListNode findBeginning(LinkedListNode head){
        LinkedListNode slowRunner = head;
        LinkedListNode fastRunner = head;

        while(fastRunner != null && fastRunner.next != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            //we have hit the collision point
            if(slowRunner == fastRunner){
                break;
            }
        }

        //check to see if we've hit the end of the linked list (i.e. no loop)
        if(fastRunner == null || fastRunner.next == null){
            return null;
        }

        //move slowRunner to head, both slowRunner and fastRunner will be equidistant
        //from the head that starts the loop
        slowRunner = head;
        while (slowRunner != fastRunner){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        return slowRunner;
    }

    public static void main(String[] args){
        LinkedListNode loopHead = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,
                                                new LinkedListNode(6,
                                                        new LinkedListNode(7,null)))))));
        loopHead.next.next.next.next.next.next = loopHead;

        LinkedListNode head = new LinkedListNode(-2,
                new LinkedListNode(-1,
                        new LinkedListNode(0, loopHead)));

        System.out.println("Current linked list structure:");
        System.out.println("-2 -> -1 -> 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> (points back to node 1)");

        LinkedListNode result = findBeginning(head);
        result.next = null;
        System.out.println(String.format(".findBeginning() result: %s", result.toString()));
    }
}
