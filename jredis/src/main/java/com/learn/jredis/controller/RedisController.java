package com.learn.jredis.controller;

import com.learn.jredis.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijy
 * @create 2019-04-15 22:17
 * @description
 */
@RestController
public class RedisController {
    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("test-set-string")
    public String testSetString() {
        redisUtils.set("testkey", "testvalue",60L);
        return "success set string";
    }

    @GetMapping("test-get-string")
    public String testGetString() {
        return redisUtils.getString("testkey");
    }

}
