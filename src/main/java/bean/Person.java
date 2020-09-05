package bean;



import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

@FacesConfig(
        // Activates CDI build-in beans
        version = JSF_2_3
)
@Named
@SessionScoped
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String age;
    private String gender;
    private String fortune;
    @Inject
    private Translator translator;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFortune() {
        return fortune;
    }

    public void setFortune(String fortune) {
        this.fortune = fortune;
    }

    public void showFortune(){
        fortune = translator.showFortune(name,age,gender);
    }

}
