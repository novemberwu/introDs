import Lab1.Joey;
import Lab1.Michael;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab1Test {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    void testHomework() {
        // Assume 'MyClass' has a method 'printMessage' that prints to System.out
        //Michael lab = new Michael();
        Joey lab  = new Joey();
        String[] args = new String[]{"Rachel", "Joe", "Ross"};
        lab.homework(args);

        assertEquals("Hi Ross, Joe and Rachel", outputStreamCaptor.toString().trim());
    }



    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
