package TDD_Exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingKataTest {

    GreetingKata greetingKata;

    @BeforeEach
    void setUp() {
        greetingKata = new GreetingKata();
    }

    @Test
    void test1GreetName() {
        String name = "michael";
        String res = greetingKata.greetName(name);

        assertEquals("Hello "+name+".", res);
    }
    @Test
    void test2GreetNameIsNull() {
        String name = null;
        String res = greetingKata.greetName(name);

        assertEquals("Hello, my friend.", res);
    }
    @Test
    void test3GreetNameIsShouted() {
        String name = "JERRY";
        String res = greetingKata.greetName(name);

        assertEquals("HELLO "+name+"!", res);
    }

    @Test
    void test4GreetNameWith2NamesAsInput() {
        String[] name = new String[]{"Jill", "Jane"};
        String res = greetingKata.greetName(name);

        assertEquals("Hello, Jill and Jane.", res);
    }
    @Test
    void test5GreetNameWithManyInputs() {
        String[] name = new String[]{"Amy", "Brian", "Charlotte"};
        String res = greetingKata.greetName(name);

        assertEquals("Hello, Amy, Brian and Charlotte.", res);
    }
    @Test
    void test6GreetNameWithAndWithoutShouting() {
        String[] name = new String[]{"Amy", "BRIAN", "Charlotte"};
        String res = greetingKata.greetName(name);

        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", res);
    }
    @Test
    void test7GreetNameStringWithComma() {
        String[] name = new String[]{"Bob", "Charlie, Dianne"};
        String res = greetingKata.greetName(name);

        assertEquals("Hello, Bob, Charlie and Dianne.", res);
    }
    @Test
    void test8GreetNameIgnore7IF() {
        String[] name = new String[]{"Bob", "\"Charlie, Dianne\""};
        String res = greetingKata.greetName(name);

        assertEquals("Hello, Bob and Charlie, Dianne.", res);
    }

}