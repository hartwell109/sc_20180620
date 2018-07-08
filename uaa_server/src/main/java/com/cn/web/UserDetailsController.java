package com.cn.web;

import com.cn.jpa.dao.UserDetailsDao;
import com.cn.jpa.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/userdetails")
public class UserDetailsController {
    @Resource
    private UserDetailsDao userDetailsDao;

    @GetMapping(value = "/findall", produces = "application/txt")
    public List<User> findAll() {
        List<User> result = userDetailsDao.findAll();
        return result;
    }
}
