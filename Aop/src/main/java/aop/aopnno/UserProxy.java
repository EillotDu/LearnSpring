package aop.aopnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

//增强的类
@Component
@Aspect
@Order(2)
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.personal.spring.aop.aopnno.User.add(..))")
    public void pointdemo() {

    }

    //前置通知
    //@Before注解表示作为前置通知
    @Before(value = "pointdemo()")
    public void before() {
        System.out.println("before......");
    }

    //最终通知
    @After(value = "execution(* com.personal.spring.aop.aopnno.User.add(..))")
    public void after() {
        System.out.println("after......");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "execution(* com.personal.spring.aop.aopnno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning......");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.personal.spring.aop.aopnno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing......");
    }

    //环绕
    @Around(value = "execution(* com.personal.spring.aop.aopnno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前......");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后......");
    }
}