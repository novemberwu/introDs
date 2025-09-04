import Lab2.Homework;
import Lab2.RachelLab;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab2Test {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private ArrayList<Homework> homeworks = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        homeworks.add( new RachelLab());
    }

    // Test cases for max

    @Test
    void testMaxRegularCase() {

        int a = 100;
        int b = 99;


        for(Homework homework: this.homeworks){
            int result = homework.max(a, b);
            assertEquals(a, result);
        }

    }
    @Test
    void testMaxOverflowCase(){
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        for(Homework homework: this.homeworks){
            int result = homework.max(a, b);
            assertEquals(a, result);
        }
    }

    @Test
    void testMaxOverflowCase2(){
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE -1;
        for(Homework homework: this.homeworks){
            int result = homework.max(a, b);
            assertEquals(a, result);
        }

    }

    @Test
    void testEqualCase(){
        int a = 99;
        int b = 99;
        for(Homework homework: this.homeworks){
            int result = homework.max(a, b);
            assertEquals(a, result);
        }
    }


    // Test case for Triangle area
    @Test
    void testTriangleArea(){
        int a = 3;
        int b = 4;
        int c = 5;


        for(Homework homework: this.homeworks){
            double area = homework.areaTriangle(a, b, c);
            assertEquals(6, area);
        }
    }

    // Test cases for Palindrome
    @Test
    void testPositiveCase(){
        String value = "A man, a plan, a canal: Panama";
        for(Homework homework: this.homeworks){
            boolean result = homework.isPalindrome(value);
            assertEquals(true, result);
        }
    }

    @Test
    void testNegtiveCase(){
        String value = "race a car";
        for(Homework homework: this.homeworks){
            boolean result = homework.isPalindrome(value);
            assertEquals(false, result);
        }
    }

    @AfterEach
    public void tearDown() {
        // nothing to restore
    }
}
