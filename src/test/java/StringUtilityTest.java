import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringUtilityTest {

    StringUtility utility;

    @BeforeEach
    void setup() {
        utility = new StringUtility();
    }

    @Test
    public void testMustBeAbleToCreateConverter() {
        assertNotNull(utility);
    }

    @Test
    public void testStringIsReversed() {
        String s = "aBc";
        var result = utility.reverse(s);

        assertEquals("cBa", result);
    }

    @ParameterizedTest(name = "should convert {arguments} to uppercase")
    @ValueSource(strings = {"aeQ", "aaa", "UUL1"})
    public void testUppercase(String string) {

        string = utility.upperCase(string);

        assertEquals(string.toUpperCase(), string);

    }

    @ParameterizedTest(name = "should convert {arguments} to lowercase")
    @ValueSource(strings = {"aeQ", "aaa", "UUL1"})
    public void testLowercase(String string) {

        string = utility.lowerCase(string);

        assertEquals(string.toLowerCase(), string);

    }
}
