package com.cn.web;

import com.cn.jpa.dao.UserBaseDao;
import com.cn.jpa.entity.UserBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/userbase")
public class UserBaseController {
    @Resource
    public UserBaseDao userBaseDao;

    @RequestMapping(value = "/findbyusername/{username}")
    public UserBase findByUsername(@PathVariable(name = "username") String username) {
        UserBase userBase = userBaseDao.findByUsername(username);
        log.debug("username={}", username);
        log.debug("UserBase={}", userBase);
        return userBase;
    }

    @CrossOrigin
    @RequestMapping(value = "/findall/{size}/{page}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public Page<UserBase> findByNoCriteria(HttpServletRequest request, @PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.unsorted());
        Page<UserBase> result = userBaseDao.findAll(pageable);
        Enumeration<String> requestHeader = request.getHeaderNames();
        log.debug("------- headers -------");
        while (requestHeader.hasMoreElements()) {
            String headerKey = requestHeader.nextElement().toString();
            //打印所有Header值
            log.debug("headerKey=" + headerKey + ";value=" + request.getHeader(headerKey));
        }
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
