package Lab4;

public class DLList<T> {
    // Node class
    static private class Node<T> {
        public T item;
        public Node next;
        public Node prev;

        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }


    public DLList(T x) {
        // your implementation here
    }

    public DLList() {
        // your implementation here
    }

    public T getFirst() {
        // your implementation here
        return null;
    }

    public void addFirst(T x) {
        // your implementation here
    }

    public T removeFirst() {
        // your implementation here
        return null;
    }
    
    public T getLast() {
        // your implementation here
        return null;
    }
    
    public void addLast(T x) {
        // your implementation here
    }

    public T removeLast() {
        // your implementation here
        return null;
    }

    public T get(int index) {
        return null;
    }

    public int size() {
        // your implementation here
        return 0;
    }

    public static void main(String[] args) {
        // test
        DLList<Integer> list = new DLList(1);
    }
    
}
