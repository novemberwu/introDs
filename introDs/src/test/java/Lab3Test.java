import Lab2.RachelLab;
import Lab3.Homework;
import Lab3.LabSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Lab3Test {

    private Homework homework;
    @BeforeEach
    public void setUp() {
       homework =  new LabSolution();
    }

    @Test
    public void testPositiveCase(){
        Double result = homework.getFxRate("08/07/2025");
        System.out.println(result);
        Assertions.assertTrue(Math.abs(7.1804- result)< 0.00000000001);


    }

    @Test
    public void testNegativeCase(){
        Double result = homework.getFxRate("08/02/2025");
        System.out.println(result);
        Assertions.assertNull(result);

    }
}
