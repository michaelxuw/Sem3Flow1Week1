import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class NonExistingTest {

    @Test
    public void testNonExisting() {
        NonExisting ne = new NonExisting(); //alt+enter = context menu with create Class.

        String actual = ne.nonExistingMethod();

        assertEquals("Hello", actual);
    }

}