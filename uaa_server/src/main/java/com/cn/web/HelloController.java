package com.cn.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    //    @PreAuthorize("ADMIN")
    @GetMapping("/hi")
    public String hi() {
        return "Hello! The spring cloud world.";
    }
}
