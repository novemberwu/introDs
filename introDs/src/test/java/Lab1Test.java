import Lab1.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab1Test {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private ArrayList<Lab1Homework> homeworks = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        homeworks.add( new Rachel());

    }


    @Test
    void testHomework() {

        String[] args = new String[]{"Rachel", "Joe", "Ross"};

        for(Lab1Homework homework: this.homeworks){
            homework.homework(args);
            assertEquals("Hi Ross, Joe and Rachel", outputStreamCaptor.toString().trim());
        }
    }


    @Test
    void testHomeworkInvalidInput(){
        String[] args = new String[]{"Rachel"};

        for(Lab1Homework homework: this.homeworks){
            homework.homework(args);
            assertEquals("",outputStreamCaptor.toString().trim());
        }
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
