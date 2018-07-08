package com.cn.web;

import com.cn.jpa.dao.UserBaseDao;
import com.cn.jpa.entity.UserBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/userbase")
public class UserBaseController {
    @Autowired
    private UserBaseDao userBaseDao;

    @GetMapping(value = "/findbyusername/{username}", produces = "application/txt")
    public UserBase findByUsername(@PathVariable(name = "username") String username) {
        UserBase userBase = userBaseDao.findByUsername(username);
        log.debug("username={}", username);
        log.debug("UserBase={}", userBase);
        return userBase;
    }

    @GetMapping(value = "/findall")
    public Page<UserBase> findbynocriteria(@PageableDefault(value = 5, size = 5, sort = {"userId"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<UserBase> result = userBaseDao.findAll(pageable);
        return result;
    }

    @GetMapping("/save")
    public UserBase save() {
        String randomStr = UUID.randomUUID().toString().replaceAll("-", "");
        log.debug("randomStr={}", randomStr);
        UserBase userBase = new UserBase();
        userBase.username = randomStr;
        userBase.password = randomStr;
        UserBase result = userBaseDao.save(userBase);
        return result;
    }
}
