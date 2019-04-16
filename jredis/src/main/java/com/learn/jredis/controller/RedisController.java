package com.learn.jredis.controller;

import com.learn.jredis.pojo.User;
import com.learn.jredis.util.RedisUtil2;
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

    @Autowired
    private RedisUtil2 redisUtil2;

    @GetMapping("test-set-string")
    public String testSetString(String key, String value) {
        redisUtils.set(key, value,60L);
        return "success set string";
    }

    @GetMapping("test-get-string")
    public String testGetString(String key) {
        return redisUtils.getString(key);
    }

    @GetMapping("test-set-string2")
    public String testSetString2(String key, String value) {
        redisUtil2.set(key, value,60L);
        return "success set string2";
    }

    @GetMapping("test-get-string2")
    public String testGetString2(String key) {
        return redisUtils.getString(key);
    }

    @GetMapping("test-set-obj")
    public String testSetObj() {
        User user = new User("木子", 20);
        redisUtil2.set(user.getUsername(), user);
        return "success set obj";
    }

    @GetMapping("test-get-obj")
    public Object testGetObj(String key) {
        return redisUtil2.get(key);
    }


}
