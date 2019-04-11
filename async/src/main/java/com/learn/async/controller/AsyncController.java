package com.learn.async.controller;

import com.learn.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijy
 * @create 2019-04-11 15:25
 * @description
 */
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("test")
    public String test() {
        try {
            Thread.sleep(1000);
            System.out.println("开始执行异步代码");
            for (int j = 0; j < 100; j++) {
                System.out.println("j = " + j);
            }
            asyncService.test();
            System.out.println("主线程执行代码");
            return "async";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
