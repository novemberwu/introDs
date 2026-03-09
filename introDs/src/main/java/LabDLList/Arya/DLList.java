package LabDLList.Arya;

public class DLList<T> implements LabDLList.DLList<T> {
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

    private Node sentinel;  // sentinel node for simplicity
    private int size;

    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public DLList(T x) {
        sentinel = new Node(null, null, null);
        Node first = new Node(x, sentinel, sentinel);
        sentinel.next = first;
        sentinel.prev = first;
        size = 1;
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

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        Node p = sentinel.next;
        for (int index = 0; index < i; index++) {
            p = p.next;
        }
        return p.item;
    }

    public static void main(String[] args) {
        DLList<Integer> list = new DLList<>();

        System.out.println("=== Test addFirst / addLast ===");
        list.addFirst(2);
        list.addLast(5);
        list.addFirst(1);

        System.out.println("Expected size = 3, Actual = " + list.size());
        System.out.println("Expected first = 1, Actual = " + list.getFirst());
        System.out.println("Expected last = 5, Actual = " + list.getLast());

        System.out.println("=== Test removeFirst / removeLast ===");
        list.removeFirst();
        list.removeLast();
        System.out.println("Expected size = 1, Actual = " + list.size());
        System.out.println("Expected first = 2, Actual = " + list.getFirst());
    }
}


