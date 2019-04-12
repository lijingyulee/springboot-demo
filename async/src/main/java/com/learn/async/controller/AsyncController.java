package com.learn.async.controller;

import com.learn.async.event.TestEvent;
import com.learn.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author lijy
 * @create 2019-04-11 15:25
 * @description
 */
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @Autowired
    private ApplicationContext publiser;

    @GetMapping("test")
    public String test() {
        try {
            Thread.sleep(1000);
            System.out.println("主线程开始");
            for (int j = 0; j < 100; j++) {
                System.out.println("j = " + j);
            }
            asyncService.test();
            System.out.println("主线程结束");
            return "async";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @GetMapping("test-listen")
    public void testListen() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
        publiser.publishEvent(new TestEvent(this, "测试事件监听"));
        for (int j = 0; j < 10; j++) {
            System.out.println("j = " + j);
        }
    }

    @GetMapping("test-future")
    public void testFuture() {
        try {
            Future<String> result1 = asyncService.firstTask();
            Future<String> result2 = asyncService.secondTask();
            Future<String> result3 = asyncService.thirdTask();
            while (true) {
                if (result1.isDone() && result2.isDone() && result3.isDone()) {
                    System.out.println("执行异步回调");
                    break;
                }
            }
            System.out.println("异步回调结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
