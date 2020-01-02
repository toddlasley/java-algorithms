// A linked list is given such that each node contains an additional random pointer
// which could point to any node in the list or null.
// Return a deep copy of the list.

// Original: https://leetcode.com/problems/copy-list-with-random-pointer/

package xyz.toddlasley.leetcode.medium.linkedlists;

public class CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node copy = null;

        if ( head != null ) {
            int index = 0;
            Node runner = head;
            Node copyRunner = null;

            while ( runner != null ) {
                Node temp = new Node(runner.val);
                runner.val = index++;
                runner = runner.next;

                if ( copyRunner == null ) {
                    copy = temp;
                    copyRunner = copy;
                } else {
                    copyRunner.next = temp;
                    copyRunner = copyRunner.next;
                }
            }

            runner = head;
            copyRunner = copy;

            while ( runner != null ) {
                if ( runner.random != null ) {
                    copyRunner.random = getNodeAtIndex(copy, runner.random.val);
                }

                runner = runner.next;
                copyRunner = copyRunner.next;
            }

        }

        return copy;
    }

    private static Node getNodeAtIndex(Node head, int index) {
        int currentIndex = 0;
        Node runner = head;

        while ( currentIndex < index ) {
            runner = runner.next;
            currentIndex++;
        }

        return runner;
    }
}
