package com.cn.jpa.dao;

import com.cn.jpa.entity.UserBase;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserBaseDao extends PagingAndSortingRepository<UserBase, String> {
    public UserBase findByUsername(String username);
}
