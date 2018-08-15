package com.cn.security;

import com.cn.jpa.dao.UserDetailsDao;
import com.cn.jpa.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserDetailsServiceImp implements org.springframework.security.core.userdetails.UserDetailsService {
    @Resource
    private UserDetailsDao userDetailsDao;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailsDao.findByUsername(username);
        return user;
    }
}
