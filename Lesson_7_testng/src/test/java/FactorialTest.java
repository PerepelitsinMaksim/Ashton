import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {

    @DataProvider(name = "factorialProvider")
    Object[][] dataProvider() {
        return new Object[][] {
                {1, 1},
                {5, 120},
                {10, 3628800},
                {15, 2004310016}
        };
    }

    @Test (dataProvider = "factorialProvider")
    public void testGetFactorial(int arg, int expected) {
        int f = Factorial.getFactorial(arg);
        System.out.println(f);
        assertEquals(f, expected);
    }
}