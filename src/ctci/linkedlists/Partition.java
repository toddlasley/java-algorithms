//2.4: Write code to partition a linked list around a value x, such that all nodes less than x come
// before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
// to be after the elements less than x. The partition element x can appear anywhere in the right partition; it does
// not need to appear between the left and right partitions.
//Solution: p. 212

package ctci.linkedlists;

public class Partition {
    public static LinkedListNode partition(LinkedListNode node, int x){
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while(node != null){
            //copy the next node into a temporary object and
            //null out the next node on the current one
            LinkedListNode next = node.next;
            node.next = null;

            if(node.data < x){
                if(beforeStart == null){
                    //this is the beginning of the before linked list
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    //set the next node equal to the node in question
                    //and then point beforeEnd to that node so that it is pointing
                    //to the last node in the list
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                //same rules apply for the after linked list
                if(afterStart == null){
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if(beforeStart == null)
            return afterStart;

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static void main(String[] args){
        LinkedListNode head = new LinkedListNode(5,
                new LinkedListNode(2,
                        new LinkedListNode(4,
                                new LinkedListNode(7,
                                        new LinkedListNode(9,
                                                new LinkedListNode(1,
                                                        new LinkedListNode(-4,null)))))));

        System.out.println("Before partition()");
        System.out.println(head.toString());
        System.out.println("After partition() at value 4");
        System.out.println(partition(head, 4).toString());
    }
}
