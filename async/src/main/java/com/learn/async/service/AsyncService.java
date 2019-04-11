package com.learn.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lijy
 * @create 2019-04-11 15:25
 * @description
 */
@Service
public class AsyncService {
    @Async
    public void test() throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < 1000; i++) {
            System.out.println("i = " + i);
        }

    }
}
