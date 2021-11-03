package aop.aopnno;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {

    //后置通知（返回通知）
    @AfterReturning(value = "execution(* com.personal.spring.aop.aopnno.User.add(..))")
    public void afterReturning() {
        System.out.println("Person AfterReturning......");
    }

    //后置通知（返回通知）
    @Before(value = "execution(* com.personal.spring.aop.aopnno.User.add(..))")
    public void after() {
        System.out.println("Person Before......");
    }
}
