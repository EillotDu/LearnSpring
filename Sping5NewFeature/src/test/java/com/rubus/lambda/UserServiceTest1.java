package com.rubus.lambda;

import com.rubus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 *
 */
/*
Spring-test整合JUnit5
 */
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class UserServiceTest1 {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.accountMoney();
    }
}
