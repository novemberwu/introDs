package LabDLList.Michael;

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

    private DLList.Node<T> sentinel;
    private int size;
    private DLList.Node<T> last;

    public DLList(T x) {
        // your implementation here
        sentinel = new Node<T>(x, null, null);
        sentinel.next = new DLList.Node<T>(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public DLList() {
        // your implementation here
        sentinel = new Node<T>(null, sentinel, sentinel);
        size = 0;
    }

    public T getFirst() {
        // your implementation here
        return (T) sentinel.next.item;
    }

    public void addFirst(T x) {
        // your implementation here
        sentinel.next = new Node<T>(x, sentinel.next, sentinel);
        size++;
    }

    public T removeFirst() {
        // your implementation here
        T x = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return x;
    }

    public T getLast() {
        // your implementation here
        return (T) sentinel.prev.item;
    }

    public void addLast(T x) {
        // your implementation here
        size++;
        sentinel.prev = new Node<T>(x, sentinel, sentinel.prev);
    }

    public T removeLast() {
        // your implementation here
        T x = (T) sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return x;
    }

    public T get(int index) {
        Node iterater = sentinel.next;
        for (int i = 0; i < index; i++) {
            iterater = iterater.next;
        }
        return (T) iterater.item;
    }

    public int size() {
        // your implementation here
        return size;
    }

    public static void main(String[] args) {
        // test
        DLList<Integer> list = new DLList<Integer>(1);
        list.addFirst(2);
        list.addFirst(3);
//        System.out.println(list.getFirst());
//        System.out.println(list.size());
//        System.out.println(list.removeFirst());
//        System.out.println(list.getFirst());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}

