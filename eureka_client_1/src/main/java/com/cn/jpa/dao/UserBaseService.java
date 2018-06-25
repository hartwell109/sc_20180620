package com.cn.jpa.dao;

import com.cn.jpa.entity.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBaseService {
    @Autowired
    private UserBaseDao userBaseDao;

    public UserBase findByUsername(String username) {
        return userBaseDao.findByUsername(username);
    }
}
