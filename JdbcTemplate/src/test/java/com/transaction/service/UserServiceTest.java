package com.transaction.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


class UserServiceTest {

    @Test
    public void transferMoneyTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/configjdbc.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void transferMoneyTestForXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/xmlfortransactional.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

}