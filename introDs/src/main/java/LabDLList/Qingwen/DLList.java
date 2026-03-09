package LabDLList.Qingwen;

public class DLList<T> implements LabDLList.DLList<T>{
    // Node class
    static private class Node<T> {
        public T item;
        public DLList.Node next;
        public DLList.Node prev;

        public Node(T item, DLList.Node next, DLList.Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private final Node<T> sentinel;
    private int size;


    public DLList(T x) {
        // your implementation here
        sentinel = new Node<>(null, null, null);
        sentinel.next = new Node<>(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public DLList() {
        // your implementation here
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public T getFirst() {
        // your implementation here
        if (size == 0) {
            return null;
        }

        return (T) sentinel.next.item;
    }

    public void addFirst(T x) {
        // your implementation here
        Node<T> newNode = new Node<>(x, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public T removeFirst() {
        // your implementation here
        if (size == 0) {
            return null;
        }

        Node<T> first = sentinel.next;
        first.next.prev = sentinel;
        sentinel.next = first.next;
        size -= 1;
        return first.item;
    }

    public T getLast() {
        // your implementation here
        if (size == 0) {
            return null;
        }

        return (T) sentinel.prev.item;
    }

    public void addLast(T x) {
        // your implementation here
        Node<T> newNode = new Node<>(x, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    public T removeLast() {
        // your implementation here
        if (size == 0) {
            return null;
        }

        Node<T> last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size -= 1;
        return last.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public int size() {
        // your implementation here
        return size;
    }

    public static void main(String[] args) {
        // test
        DLList<Integer> list = new DLList(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(5);
        System.out.println(list.get(0));
    }

}
