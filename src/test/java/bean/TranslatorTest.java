package bean;

import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class TranslatorTest {

    private Dice dice;
    private Translator translator;

    @Before
    public void setup(){
        dice = new Dice();
        translator = new Translator();
        translator.setDice(dice);
    }
    @Test
    public void showFortuneTest() {
        dice.setRandom(6);
        String fortune = translator.showFortune("User","24","Male");
        assertTrue(fortune.contains("Perfect sign,"));
        dice.setRandom(3);
        fortune = translator.showFortune("User","24","Male");
        assertTrue(fortune.contains("Something you have to take care,"));
        assertTrue(fortune.contains("User"));
        assertTrue(fortune.contains("24"));
        assertTrue(fortune.contains("Male"));
    }

    @Test
    public void getDice() {
        Dice myDice = translator.getDice();
        assertSame(myDice,dice);
    }

    @Test
    public void setDice() {
        Dice myDice = new Dice();
        translator.setDice(myDice);
        assertSame(myDice,translator.getDice());
    }
}