package aspect.oriented;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Aspect




@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("aspect.oriented.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): " + methodSignature.getName());
        if (methodSignature.getName().equals("validate")) {
            Object[] arg = joinPoint.getArgs();
            for (Object obj : arg) {
                if (obj instanceof Auditing) {
                    Auditing myBook = (Auditing) obj;
                    System.out.println("Name: " + myBook.getNameAuditing() + "Surname: " + myBook.getSurnameAuditing());
                } else if (obj instanceof String)
                    System.out.println("book add by -" + obj);
            }
        }
        System.out.println("beforeAddLoggingAdvice: логгирование попытки получить книгу/журнал");
        System.out.println("----------------------------");
    }

    @Before("execution(public void aspect.oriented.Auditing.*())")
    public void beforeGetValidate() {
        System.out.println("beforeGetValidating: попытка...");
    }
}

//    @Before("execution(public void aspect.oriented.Auditing.transferInstantiate())")
//    public void beforeGetTransfer(){
//        System.out.println("beforeGetTransfer: попытка создания экземпляра");
//    }
//
//    @Before("execution(public void aspect.oriented.Auditing.success())")
//    public void beforeGetSuccess(){
//        System.out.println("beforeGetSuccess: попытка транзакции");
//    }

