package LabDLList.Youyi;

public class DLList<T> implements LabDLList.DLList<T> {
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

    private Node sentinel;
    private int size;

    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public DLList(T x) {
        this();
        addLast(x);
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
        if (isEmpty()) return null;
        return sentinel.next.item;
    }

    public T getLast() {
        if (isEmpty()) return null;
        return sentinel.prev.item;
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (isEmpty()) return null;
        Node last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return last.item;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        DLList<Integer> list = new DLList<>();

        System.out.println("== Testing addFirst / addLast ==");
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);
        System.out.println("Expected size 3 -> " + list.size());
        System.out.println("First: " + list.getFirst() + ", Last: " + list.getLast()); // 5, 20

        System.out.println("== Testing removeFirst / removeLast ==");
        list.removeFirst();
        list.removeLast();
        System.out.println("Expected size 1 -> " + list.size());
        System.out.println("Remaining: " + list.getFirst());

        System.out.println("== Testing get(index) ==");
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        System.out.println("Element at index 1: " + list.get(1)); // 30

        System.out.println("== Testing constructor DLList(T x) ==");
        DLList<String> sList = new DLList<>("hello");
        System.out.println("First element: " + sList.getFirst());
    }
}
