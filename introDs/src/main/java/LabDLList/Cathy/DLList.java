package LabDLList.Cathy;

public class DLList<T>  implements LabDLList.DLList<T> {
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

    /** Constructor for empty list */
    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Constructor for list with one element */
    public DLList(T x) {
        this();
        addFirst(x);
    }

    /** Add item to the front (constant time) */
    public void addFirst(T x) {
        Node newNode = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    /** Add item to the end (constant time) */
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    /** Get first item */
    public T getFirst() {
        if (size == 0) return null;
        return sentinel.next.item;
    }

    /** Get last item */
    public T getLast() {
        if (size == 0) return null;
        return sentinel.prev.item;
    }

    /** Remove first item (constant time) */
    public T removeFirst() {
        if (size == 0) return null;
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.item;
    }

    /** Remove last item (constant time) */
    public T removeLast() {
        if (size == 0) return null;
        Node last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return last.item;
    }

    /** Return number of elements */
    public int size() {
        return size;
    }

    /** Get element at index (0-based). Loops allowed. */
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    /** Print all elements for debugging */
    public void printList() {
        Node current = sentinel.next;
        System.out.print("[ ");
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    /** ---------- Test cases ---------- */
    public static void main(String[] args) {
        // Test 1: Setup - create empty list
        DLList<Integer> list = new DLList<>();
        System.out.println("Test 1: Empty list created.");
        System.out.println("Expected size = 0, Actual = " + list.size());
        assert list.size() == 0;

        // Test 2: Execution - addFirst
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        System.out.println("Test 2: After adding elements:");
        list.printList();
        assert list.getFirst() == 20;
        assert list.getLast() == 30;
        assert list.size() == 3;

        // Test 3: Get by index
        System.out.println("Test 3: get(1) = " + list.get(1));
        assert list.get(1) == 10;

        // Test 4: Remove operations
        int firstRemoved = list.removeFirst();
        int lastRemoved = list.removeLast();
        System.out.println("Test 4: Removed first=" + firstRemoved + ", last=" + lastRemoved);
        list.printList();
        assert firstRemoved == 20;
        assert lastRemoved == 30;
        assert list.size() == 1;

        // Test 5: Constructor with one element
        DLList<String> strList = new DLList<>("hello");
        System.out.println("Test 5: String list initialized:");
        strList.printList();
        assert strList.getFirst().equals("hello");
        assert strList.size() == 1;

        System.out.println("\n✅ All tests passed successfully!");
    }
}
