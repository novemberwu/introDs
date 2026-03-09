import SymbolTable.BST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

    @Test
    public void testPutWithNullTree(){
        BST<Integer, Integer> emptyTree = new BST<Integer, Integer>();

        assertTrue(emptyTree.isEmpty());

        emptyTree.put(1,1);

        assertFalse(emptyTree.isEmpty());

    }

    @Test
    public  void testPutWithOneNode(){
        BST<Integer, Integer> tree = new BST<>();
        tree.put(1,1);
        assertEquals(1, tree.get(1));

        tree.put(1,2);
        assertEquals(2, tree.get(1));
    }
}
