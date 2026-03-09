import SymbolTable.BST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

    @Test
    public void testPutWithNull(){
        BST<Integer, Integer> emptyTree = new BST<Integer, Integer>();

        assertTrue(emptyTree.isEmpty());

        emptyTree.put(1,1);

        assertFalse(emptyTree.isEmpty());

    }
}
