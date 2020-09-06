package bean;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Dice dice;
    private Translator translator;
    private Person person;
    @Before
    public void setUp() throws Exception {
       dice = new Dice();
       translator = new Translator();
       translator.setDice(dice);
       person = new Person();
       person.setTranslator(translator);
    }
    @Test
    public void showFortune() {
        translator.setDice(dice);
        person.setFortune(translator.showFortune("User","24","Male"));
        assertTrue(person.getFortune().contains("User"));
        assertTrue(person.getFortune().contains("24"));
        assertTrue(person.getFortune().contains("Male"));
    }

    @Test
    public void getName() {
        String name = "Marry";
        person.setName(name);
        assertEquals("Marry",person.getName());
    }

    @Test
    public void setName() {
        String name = "Henry";
        person.setName(name);
        assertEquals("Henry",person.getName());
    }

    @Test
    public void getAge() {
        String age = "24";
        person.setAge(age);
        assertEquals("24",person.getAge());
    }

    @Test
    public void setAge() {
        String age = "28";
        person.setAge(age);
        assertEquals("28",person.getAge());
    }

    @Test
    public void getGender() {
        String gender = "Male";
        person.setGender(gender);
        assertEquals("Male",person.getGender());
    }

    @Test
    public void setGender() {
        String gender = "Female";
        person.setGender(gender);
        assertEquals("Female",person.getGender());
    }

    @Test
    public void getFortune() {
        String fortune = "Good luck";
        person.setFortune(fortune);
        assertEquals("Good luck",person.getFortune());
    }

    @Test
    public void setFortune() {
        String fortune = "Bad luck";
        person.setFortune(fortune);
        assertEquals("Bad luck",person.getFortune());
    }

    @Test
    public void getTranslator() {
        Translator myTranslator = person.getTranslator();
        assertSame(translator,myTranslator);
    }

    @Test
    public void setTranslator() {
        Translator myTranslator = new Translator();
        person.setTranslator(myTranslator);
        assertSame(myTranslator,person.getTranslator());
    }


}