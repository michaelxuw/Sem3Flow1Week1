import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addNumbers() {
        System.out.println("Testing the addNumbers method in calculator");
        int actual = new Calculator().addNumbers(5,7);
        int expected = 12;
        assertEquals(expected,actual);
    }

}