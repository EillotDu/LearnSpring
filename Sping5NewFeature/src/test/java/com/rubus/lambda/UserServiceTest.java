package com.rubus.lambda;

import com.rubus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean1.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.accountMoney();
    }
}
