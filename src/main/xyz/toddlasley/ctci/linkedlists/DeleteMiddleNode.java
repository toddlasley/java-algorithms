//2.3: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
// not necessarily the exact middle) of a singly linked list, given only access to that node.
//Solution: p. 211

package xyz.toddlasley.ctci.linkedlists;

public class DeleteMiddleNode {
    public static void deleteMiddleNode(LinkedListNode node){
        if(node.next == null)
            return;

        LinkedListNode copy = node.next;
        node.data = copy.data;
        node.next = copy.next;
    }

    public static void main(String[] args){
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(1,
                                        new LinkedListNode(4,null)))));

        LinkedListNode delete = head.next.next;

        System.out.println("Before deleteMiddleNode()");
        System.out.println(head.toString());
        deleteMiddleNode(delete);
        System.out.println("After deleteMiddleNode()");
        System.out.println(head.toString());
    }
}
