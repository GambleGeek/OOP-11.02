package aspect.oriented;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.rmi.runtime.Log;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //UniLibrary unilibrary=context.getBean("uniLibrary",UniLibrary.class);


        Auditing validating = context.getBean("auditing", Auditing.class);

        Scanner sc = new Scanner(System.in);
        String login = "123";
        String password = "123";

        System.out.println("Введите логин: ");
        String log = sc.nextLine();
        System.out.println("Введите пароль: ");
        String pas = sc.nextLine();


        if (log.equals(login) && password.equals(pas)){
            validating.validate("Adis", "Kerimov");
        }else
            System.out.println("Error");

        Auditing transfer = context.getBean("auditing", Auditing.class);
        Auditing success = context.getBean("auditing", Auditing.class);

        transfer.transferInstantiate();

        success.success();



        context.close();
    }
}
