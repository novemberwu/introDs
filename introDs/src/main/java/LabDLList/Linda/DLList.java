package LabDLList.Linda;

public class DLList<T> implements LabDLList.DLList<T> {
    /** Node class for doubly linked list */
    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;  // sentinel node for circular structure
    private int size;

    /** Creates an empty list */
    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Creates a list with one element x */
    public DLList(T x) {
        this();
        addFirst(x);
    }


    public void addFirst(T x) {
        Node newNode = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T x) {
        Node newNode = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.item;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.prev.item;
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return last.item;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }
}

