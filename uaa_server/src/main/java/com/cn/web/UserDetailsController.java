package com.cn.web;

import com.cn.jpa.dao.UserDetailsDao;
import com.cn.jpa.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/userdetails")
public class UserDetailsController {
    @Resource
    private UserDetailsDao userDetailsDao;

    @RequestMapping(value = "/findall")
    public List<User> findAll() {
        List<User> result = userDetailsDao.findAll();
        return result;
    }
}
