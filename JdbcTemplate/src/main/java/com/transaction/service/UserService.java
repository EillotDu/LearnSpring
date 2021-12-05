package com.transaction.service;

import com.transaction.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(timeout = 10, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
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
        //可加入异常
        //mary多100
        userDao.addMoney();
    }

}
