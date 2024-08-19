import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {


    public static Object[][] dataProvider() {
        return new Object[][] {
                {1, 1},
                {5, 120},
                {10, 3628800},
                {15, 2004310016}
        };
    }

    @ParameterizedTest
    @MethodSource ("dataProvider")
    void factorial(int arg, int expected) {
        int f = Factorial.getFactorial(arg);
        assertEquals(f, expected);
    }
}