package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Translator {
    @Inject
    private Dice dice;

    public String showFortune(String name,String age, String gender){
        StringBuilder result = new StringBuilder("");
        if(dice.getRandom() >= 5){
            result.append("Perfect sign, ");
        }else {
            result.append("Something you have to take care, ");
        }
        result.append(" according to your name: ").append(name).append(", your age: ").append(age).append(", and your gender: ").append(gender);
        result.append( ", you should eat well and sleep well. You will have a better future!");
        return result.toString();
    }
}
