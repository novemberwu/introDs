import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LabDLList.DLList;

public class DLListTest {
    private DLList<String> deque;

    @BeforeEach
    public void setUp() {
        // Create a new DLList instance for each test
        deque = new LabDLList.Cathy.DLList<>();
    }
    /**
     * add tests
     */

    @Test
    public void addFirstFromEmpty(){
        //Check that addFirst works on an empty deque.
        assertEquals(0, deque.size());
        
        deque.addFirst("first");
        assertEquals(1, deque.size());
        assertEquals("first", deque.getFirst());
        assertEquals("first", deque.getLast());
    }

    @Test
    public void addLastFromEmpty(){
        //Check that addLast works on an empty deque.
        assertEquals(0, deque.size());
        
        deque.addLast("last");
        assertEquals(1, deque.size());
        assertEquals("last", deque.getFirst());
        assertEquals("last", deque.getLast());
    }

    @Test
    public void addFirstNonEmpty(){
        //Check that addFirst works on a non-empty deque.
        deque.addFirst("original");
        assertEquals(1, deque.size());
        
        deque.addFirst("newFirst");
        assertEquals(2, deque.size());
        assertEquals("newFirst", deque.getFirst());
        assertEquals("original", deque.getLast());
    }

    @Test
    public void addLastNonEmpty(){
        //Check that addLast works on a non-empty deque.
        deque.addLast("original");
        assertEquals(1, deque.size());
        
        deque.addLast("newLast");
        assertEquals(2, deque.size());
        assertEquals("original", deque.getFirst());
        assertEquals("newLast", deque.getLast());
    }

    /**
     * add after remove test
     */
    @Test
    public void addFirstAfterRemoveToEmpty(){
        //Add some elements to a deque and remove them all, then check that addFirst still works
        deque.addFirst("first");
        deque.addFirst("second");
        deque.addFirst("third");
        assertEquals(3, deque.size());
        
        // Remove all elements
        assertEquals("third", deque.removeFirst());
        assertEquals("second", deque.removeFirst());
        assertEquals("first", deque.removeFirst());
        assertEquals(0, deque.size());
        
        // Test addFirst after removing all elements
        deque.addFirst("newFirst");
        assertEquals(1, deque.size());
        assertEquals("newFirst", deque.getFirst());
        assertEquals("newFirst", deque.getLast());
    }
    @Test
    public void addLastAfterRemoveToEmpty(){
        //Add some elements to a deque and remove them all, then check that addLast still works.
        deque.addLast("first");
        deque.addLast("second");
        deque.addLast("third");
        assertEquals(3, deque.size());
        
        // Remove all elements
        assertEquals("third", deque.removeLast());
        assertEquals("second", deque.removeLast());
        assertEquals("first", deque.removeLast());
        assertEquals(0, deque.size());
        
        // Test addLast after removing all elements
        deque.addLast("newLast");
        assertEquals(1, deque.size());
        assertEquals("newLast", deque.getFirst());
        assertEquals("newLast", deque.getLast());
    }

    /**
     * Remove tests
     */

    @Test
    public void removeFirst(){

        //Check that removeFirst works.
        deque.addFirst("first");
        deque.addFirst("second");
        deque.addFirst("third");
        assertEquals(3, deque.size());
        
        assertEquals("third", deque.removeFirst());
        assertEquals(2, deque.size());
        assertEquals("second", deque.getFirst());
        assertEquals("first", deque.getLast());
    }

    @Test
    public void removeLast(){
        //Check that removeLast works.
        deque.addLast("first");
        deque.addLast("second");
        deque.addLast("third");
        assertEquals(3, deque.size());
        
        assertEquals("third", deque.removeLast());
        assertEquals(2, deque.size());
        assertEquals("first", deque.getFirst());
        assertEquals("second", deque.getLast());
    }

    @Test
    public void removeFirstToEmpty(){
        //Add some elements to a deque and remove almost all of them. Check that removing the last element with removeFirst works.
        deque.addFirst("first");
        deque.addFirst("second");
        deque.addFirst("third");
        assertEquals(3, deque.size());
        
        // Remove first two elements
        assertEquals("third", deque.removeFirst());
        assertEquals("second", deque.removeFirst());
        assertEquals(1, deque.size());
        
        // Remove the last element
        assertEquals("first", deque.removeFirst());
        assertEquals(0, deque.size());
        assertNull(deque.getFirst());
        assertNull(deque.getLast());
    }

    @Test
    public void removeLastToEmpty(){
        //Add some elements to a deque and remove almost all of them. Check that removing the last element with removeLast works.
        deque.addLast("first");
        deque.addLast("second");
        deque.addLast("third");
        assertEquals(3, deque.size());
        
        // Remove last two elements
        assertEquals("third", deque.removeLast());
        assertEquals("second", deque.removeLast());
        assertEquals(1, deque.size());
        
        // Remove the last element
        assertEquals("first", deque.removeLast());
        assertEquals(0, deque.size());
        assertNull(deque.getFirst());
        assertNull(deque.getLast());
    }

    @Test
    public void removeFirstToOne(){
        //Add some elements to a deque and remove almost all of them. Check that removing the second to last element with removeFirst works
        deque.addFirst("first");
        deque.addFirst("second");
        deque.addFirst("third");
        assertEquals(3, deque.size());
        
        // Remove first element, leaving two elements
        assertEquals("third", deque.removeFirst());
        assertEquals(2, deque.size());
        assertEquals("second", deque.getFirst());
        assertEquals("first", deque.getLast());
        
        // Verify we can still remove the remaining elements
        assertEquals("second", deque.removeFirst());
        assertEquals(1, deque.size());
        assertEquals("first", deque.getFirst());
        assertEquals("first", deque.getLast());
    }

    @Test
    public void removeLastToOne(){
        //Add some elements to a deque and remove almost all of them. Check that removing the second to last element with removeLast works.
        deque.addLast("first");
        deque.addLast("second");
        deque.addLast("third");
        assertEquals(3, deque.size());
        
        // Remove last element, leaving two elements
        assertEquals("third", deque.removeLast());
        assertEquals(2, deque.size());
        assertEquals("first", deque.getFirst());
        assertEquals("second", deque.getLast());
        
        // Verify we can still remove the remaining elements
        assertEquals("second", deque.removeLast());
        assertEquals(1, deque.size());
        assertEquals("first", deque.getFirst());
        assertEquals("first", deque.getLast());
    }
}
