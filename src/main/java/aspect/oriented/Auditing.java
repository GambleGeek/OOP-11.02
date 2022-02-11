package aspect.oriented;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Auditing {

    @Value("Adis")
    private String nameAuditing;

    @Value("Kerimov")
    private String surnameAuditing;

    public String getNameAuditing() {
        return nameAuditing;
    }

    public void setNameAuditing(String nameAuditing) {
        this.nameAuditing = nameAuditing;
    }

    public String getSurnameAuditing() {
        return surnameAuditing;
    }

    public void setSurnameAuditing(String surnameAuditing) {
        this.surnameAuditing = surnameAuditing;
    }

    // До перевода средств
    public void validate(String name, String surname){
        this.nameAuditing = name;
        this.surnameAuditing = surname;
        System.out.println("банк проверяет ваши учетные данные до перевода средств");
    }
// До перевода средств
    public void transferInstantiate(){
        System.out.println("банк создает экземпляр сервиса перевода средств");
    }
// После перевода средств
    public void success(){
        System.out.println("банк успешно выполнил перевод средств");
    }
// После неудачного перевода средств
    public void rollback() {
        System.out.println("банк откатил операцию перевода средств");
    }
}
