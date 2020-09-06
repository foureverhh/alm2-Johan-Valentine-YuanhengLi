package bean;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {
    private Dice dice;

    @Before
    public void setUp() throws Exception {
        dice = new Dice();
    }

    @Test
    public void setMyRandomTest() {
        for (int i = 0; i < 1000; i++) {
            int value = dice.setMyRandom();
            assertTrue((value >= 1) && (value <= 10) );
        }
    }

    @Test
    public void getRandom() {
        int myRandom = 100;
        dice.setRandom(myRandom);
        assertEquals(100,dice.getRandom());
    }

    @Test
    public void setRandom() {
        int myRandom = 200;
        dice.setRandom(myRandom);
        assertEquals(200,dice.getRandom());
    }
}