package com.learn.exception.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijy
 * @create 2019-06-01 20:22
 * @description
 */
@RestController
public class ExceptionController {

    @RequestMapping("test-exception")
    public void testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException("服务器发生错误，请联系管理员");
        }
    }

}
