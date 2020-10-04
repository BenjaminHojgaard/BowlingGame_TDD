import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BowlingGameTest {

    BowlingGame bowlingGame;

    @BeforeEach
    void setup() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void testMustBeAbleToCreateConverter() {
        assertNotNull(bowlingGame);
    }

    @Test
    void testGutterGame() {
        rollMany(20, 0);
        assertEquals(0, bowlingGame.score());
    }

    @Test
    void testAllOnes() {
        rollMany(20, 1);
        assertEquals(20, bowlingGame.score());
    }

    @Test
    void testOneSpare() {
        rollSpare();
        bowlingGame.roll(3);
        rollMany(17, 0);
        assertEquals(16, bowlingGame.score());
    }

    @Test
    void testOneStrike() {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rollMany(16, 0);
        assertEquals(24, bowlingGame.score());
    }

    @Test
    void testPerfectGame() {
        rollMany(12,10);
        assertEquals(300, bowlingGame.score());
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 20, 1000, 2147483647})
    void testShouldThrowExceptionWhenPinCountAbove10(int value) {

        Exception thrown = assertThrows(
                IllegalArgumentException.class, () -> rollMany(10,value)
        );

        assertTrue(thrown.getMessage().contains("Pin count must be between 0-10"));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -20, -1000, -2147483647})
    void testShouldThrowExceptionWhenGivenNegativeArguments(int value) {

        Exception thrown = assertThrows(
                IllegalArgumentException.class, () -> bowlingGame.roll(value)
        );

        assertTrue(thrown.getMessage().contains("Pin count must be between 0-10"));
    }

    @Test
    void testShouldHandleEdgeValueOfZero() {
        bowlingGame.roll(0);

        assertEquals(0, bowlingGame.score());
    }

    @Test
    void testShouldHandleEdgeValueOfTen() {
        rollStrike();
        rollMany(19,0);
        assertEquals(10, bowlingGame.score());

    }



    void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            bowlingGame.roll(pins);
        }
    }

    void rollStrike() {
        bowlingGame.roll(10);
    }

    void rollSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }
}
