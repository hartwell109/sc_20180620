package com.cn.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${my.name}")
    private String hostname;

    @Value("${my.uuid}")
    private String uuid;

    @Value("${foo}")
    private String foo;

    @GetMapping(value = "/hi", produces = "application/txt")
    public String hello() {
        String result = "\nhostname=" + this.hostname + "\nUUID=" + this.uuid + "\nfoo=" + this.foo;
        log.debug(result);
        return result;
    }
}
