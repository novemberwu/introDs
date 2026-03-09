package LabDLList.Linda;

public class TestDLList {
    public static void main(String[] args) {
        DLList<Integer> list = new DLList<>();

        // Test add
        list.addFirst(2);
        list.addLast(3);
        assert list.getFirst() == 2;
        assert list.getLast() == 3;

        // Test remove
        list.removeFirst();
        assert list.getFirst() == 3;

        // Test size
        assert list.size() == 1;

        System.out.println("All tests passed!");
    }
}