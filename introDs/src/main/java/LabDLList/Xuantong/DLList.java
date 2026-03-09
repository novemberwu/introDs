package LabDLList.Xuantong;

public class DLList<T> implements LabDLList.DLList<T>{
    private Node sentinel;
    private int size;

    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    // Task D: Default constructor
    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // Task D: Constructor with one element
    public DLList(T x) {
        this();
        addLast(x);
    }

    // Task B: Add to front in O(1)
    public void addFirst(T x) {
        Node newNode = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    // Task B: Add to back in O(1)
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    // Task C: Get first item
    public T getFirst() {
        if (size == 0) {
            return null; // or throw exception; lab doesn't specify
        }
        return sentinel.next.item;
    }

    // Task C: Get last item
    public T getLast() {
        if (size == 0) {
            return null;
        }
        return sentinel.prev.item;
    }

    // Task E: Remove and return first item
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node first = sentinel.next;
        T item = first.item;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return item;
    }

    // Task E: Remove and return last item
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node last = sentinel.prev;
        T item = last.item;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return item;
    }

    // Task F: Return number of elements
    public int size() {
        return size;
    }

    // Task G: Get item at index (0-based); O(n)
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null; // or throw IndexOutOfBoundsException
        }
        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }
}
