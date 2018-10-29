package ctci.linkedlists;

public class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data, LinkedListNode node){
        this.data = data;
        this.next = node;
    }

    @Override()
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d -> ", this.data));
        LinkedListNode copy = next;
        while(copy != null){
            sb.append(String.format("%d -> ", copy.data));
            copy = copy.next;
        }

        return sb.toString();
    }
}
