package com.learn.threadpool.pojo.callable;

import java.util.concurrent.Callable;

/**
 * @author lijy
 * @create 2019-06-01 15:48
 * @description
 */
public class CallThread implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(1000);
        return "callable and future";
    }
}
