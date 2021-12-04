package com.transaction.service;

import com.transaction.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    //转账的方法
    public void accountMoney() {
        //lucy少100
        userDao.reduceMoney();

        //mary多100
        userDao.addMoney();
    }

}
