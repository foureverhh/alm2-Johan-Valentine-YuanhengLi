package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Random;

@Named
@RequestScoped
public class Dice {
    private int random;

    public Dice() {
        random = new Random().nextInt(10) + 1;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }
}
