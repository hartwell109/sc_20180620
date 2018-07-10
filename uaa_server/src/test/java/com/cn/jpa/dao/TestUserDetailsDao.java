package com.cn.jpa.dao;

import com.cn.jpa.entity.Role;
import com.cn.jpa.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestUserDetailsDao {
    @Resource
    private UserDetailsDao userDetailsDao;

    @Resource
    private GrantedAuthorityDao grantedAuthorityDao;

    @Test
    public void testInitGrantAuthority() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_GUEST");
        for (int i = 0; i < roles.size(); ++i) {
            Role role = new Role();
            role.setAuthority(roles.get(i));
            grantedAuthorityDao.saveAndFlush(role);
        }
    }

    @Test
    public void testInitUserDetails() {
        for (int i = 0; i < 100; i++) {
            String randomString = UUID.randomUUID()
                    .toString()
                    .replaceAll("-", "")
                    .substring(23, 31)
                    .toUpperCase();
            User user = new User();
            user.setUsername(randomString);
            user.setPassword(randomString);
            List<Role> roleList = grantedAuthorityDao.findAll();
            user.setAuthorities(roleList);
            userDetailsDao.saveAndFlush(user);
        }
    }

    @Test
    public void testFindAuthorityByUsername() {
        String username = "78D9AD0F";
        UserDetails userDetails = userDetailsDao.findByUsername(username);
        List<Role> list = (List<Role>) userDetails.getAuthorities();
        log.debug("role size is {}", list.size());
        for (int i = 0; i < list.size(); ++i) {
            Role role = list.get(i);
            log.debug("Role ={}", role.getAuthority());
        }
    }
}
