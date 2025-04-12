package me.toddlasley.questions.interviews.linkedlist;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    static class Node {
        public Node prev;
        public Node next;
        public int key;
        public int value;

        public Node(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

    }

    private final int capacity;
    private final Map<Integer, Node> map;

    private Node first;
    private Node last;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(final int key) {
        final Node result = map.get(key);

        if (result != null) {
            moveNodeToFront(result);

            return result.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        final Node current = map.getOrDefault(key, new Node(key, value));
        current.value = value;

        if (first == null) {
            first = current;
        }

        if (last == null) {
            last = current;
        }

        moveNodeToFront(current);

        map.put(key, current);

        if (map.size() > capacity) {
            map.remove(last.key);
            last = last.prev;
            last.next = null;
        }
    }

    private void moveNodeToFront(final Node node) {
        if (node != first) {
            final Node prev = node.prev;
            final Node next = node.next;

            node.prev = null;
            node.next = first;
            first.prev = node;
            first = node;

            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
            } else if (first == last) {
                last = prev;
            }
        }
    }
}
