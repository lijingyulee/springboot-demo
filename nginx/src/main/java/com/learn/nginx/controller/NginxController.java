package com.learn.nginx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijy
 * @create 2019-06-11 22:15
 * @description
 */
@RestController
public class NginxController {

    @Value("${server.port}")
    private String port;

    @GetMapping("test")
    public String test() {
        return "端口号：" + port;
    }
}
