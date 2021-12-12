package com.rubus.lambda;

import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;


class UserTest {

    //函数式风格创建对象，交给spring进行管理
    @Test
    public void lambdaCreateObject() {
        //1. 创建GenericApplicationContext
        GenericApplicationContext context = new GenericApplicationContext();
        //2. 调用context的方法对象注册
        context.refresh();
        context.registerBean(User.class, () -> new User());
        //3. 获取在Spring注册的对象
        User user = (User) context.getBean("com.rubus.lambda.User");
        System.out.println(user);
    }

    //函数式风格创建对象，交给spring进行管理
    @Test
    public void lambdaCreateObject1() {
        //1. 创建GenericApplicationContext
        GenericApplicationContext context = new GenericApplicationContext();
        //2. 调用context的方法对象注册
        context.refresh();
        context.registerBean("user1", User.class, () -> new User());
        //3. 获取在Spring注册的对象
        User user = (User) context.getBean("user1");
        System.out.println(user);
    }

}