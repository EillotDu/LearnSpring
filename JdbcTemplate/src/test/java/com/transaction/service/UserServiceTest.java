package com.transaction.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


class UserServiceTest {
    UserService userService;

    @BeforeEach
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/configjdbc.xml");
        userService = context.getBean("userService", UserService.class);
    }

    @Test
    public void transferMoneyTest() {
        userService.accountMoney();
    }

}