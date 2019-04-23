package xyz.toddlasley.ctci.linkedlists.types;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(){ }

    public LinkedListNode(int data, LinkedListNode node){
        this.data = data;
        this.next = node;
    }

    public void setNext(LinkedListNode next){
        if(this.next == null){
            this.next = next;
        } else {
            LinkedListNode node = this.next;
            while(node.next != null){
                node = node.next;
            }
            node.next = next;
        }
    }

    public int length(){
        int count = 1;
        LinkedListNode node = this.next;
        while(node != null){
            count++;
            node = node.next;
        }

        return count;
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
