package com.learn.jredis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author lijy
 * @create 2019-04-15 22:15
 * @description
 */
@Component
public class RedisUtils {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, Object object, Long time) {
        // 让该方法能够支持多种数据类型存放
        if (object instanceof String) {
            setString(key, object);
        }
        // 如果存放时Set类型
        if (object instanceof Set) {
            setSet(key, object);
        }
        // 设置有效期
        if (time != null) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }

    }

    public void setString(String key, Object object) {
        String value = (String) object;
        // 存放string类型
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void setSet(String key, Object object) {
        Set<String> valueSet = (Set<String>) object;
        for (String string : valueSet) {
            stringRedisTemplate.opsForSet().add(key, string);
        }
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}
