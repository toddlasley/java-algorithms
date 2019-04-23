package xyz.toddlasley.ctci.linkedlists.types;

public class IntersectionResult {
    public LinkedListNode tail;
    public int size;
    public IntersectionResult(LinkedListNode tail, int size){
        this.tail = tail;
        this.size = size;
    }
}
