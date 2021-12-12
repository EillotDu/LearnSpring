package com.rubus.transaction.service;

import com.rubus.transaction.config.TxConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    @Test
    public void totalAnnotationTransaction() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

}