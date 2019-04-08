package com.learn.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijy
 * @create 2019-04-08 17:40
 * @description
 */
@RestController
public class HelloController {
    @GetMapping("hello-world")
    public String helloWorld() {
        return "hello world";
    }
}
