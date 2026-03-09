package LabDLList.Xuantong;

public class DLListTest {
    public static void main(String[] args) {
        // Test Task A + D: Constructors
        DLList<Integer> list1 = new DLList<>();
        DLList<Integer> list2 = new DLList<>(10);

        assert list1.size() == 0 : "Empty list size should be 0";
        assert list2.size() == 1 : "Single-element list size should be 1";
        assert list2.getFirst().equals(10) : "First should be 10";
        assert list2.getLast().equals(10) : "Last should be 10";

        // Test Task B: addFirst and addLast
        list1.addLast(1);
        list1.addFirst(0);
        assert list1.size() == 2;
        assert list1.getFirst() == 0;
        assert list1.getLast() == 1;

        // Test Task C: getFirst/getLast
        assert list1.getFirst() == 0;
        assert list1.getLast() == 1;

        // Test Task E: removeFirst/removeLast
        Integer removed = list1.removeFirst();
        assert removed == 0;
        assert list1.size() == 1;
        assert list1.getFirst() == 1;

        removed = list1.removeLast();
        assert removed == 1;
        assert list1.size() == 0;
        assert list1.getFirst() == null;
        assert list1.getLast() == null;

        // Test Task G: get by index
        DLList<String> strList = new DLList<>();
        strList.addLast("A");
        strList.addLast("B");
        strList.addLast("C");
        assert strList.get(0).equals("A");
        assert strList.get(1).equals("B");
        assert strList.get(2).equals("C");
        assert strList.get(3) == null; // out of bounds
        assert strList.get(-1) == null; // invalid index

        System.out.println("All tests passed!");
    }
}
