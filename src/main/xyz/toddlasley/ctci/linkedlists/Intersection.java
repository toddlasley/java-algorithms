//2.7: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
// Note that the intersection is defined based on reference, not value. That is, if the kth node of the first
// linked ist is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
//Solution: p. 221

package xyz.toddlasley.ctci.linkedlists;

public class Intersection {
    public static LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2){
        if(l1 == null || l2 == null)
            return null;

        IntersectionResult result1 = getLengthAndTail(l1);
        IntersectionResult result2 = getLengthAndTail(l2);

        //if the two lists do not have the same tail,
        //they do not intersect
        if(result1.tail != result2.tail)
            return null;

        LinkedListNode shorter = result1.size < result2.size ? l1 : l2;
        LinkedListNode longer = result1.size < result2.size ? l2 : l1;

        //move forward on the longer list
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while(shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }

    public static IntersectionResult getLengthAndTail(LinkedListNode head){
        int length = 1;
        while(head.next != null){
            head = head.next;
            length++;
        }

        return new IntersectionResult(head, length);
    }

    public static LinkedListNode getKthNode(LinkedListNode head, int k){
        for(int i = 0; i < k; i++){
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args){
        LinkedListNode intersection = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,
                                                new LinkedListNode(6,
                                                        new LinkedListNode(7,null)))))));

        LinkedListNode head1 = new LinkedListNode(2,
                new LinkedListNode(1,
                        new LinkedListNode(0, intersection)));

        LinkedListNode head2 = new LinkedListNode(-2,
                new LinkedListNode(-1,
                        new LinkedListNode(0, intersection)));

        System.out.println(String.format("Intersection of %s", head1.toString()));
        System.out.println(String.format("and %s", head2.toString()));
        System.out.println(findIntersection(head1, head2).toString());
    }
}
