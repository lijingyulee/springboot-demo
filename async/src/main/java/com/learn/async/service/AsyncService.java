package com.learn.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author lijy
 * @create 2019-04-11 15:25
 * @description
 */
@Service
public class AsyncService {

    public static Random random =new Random();

    @Async
    public void test() throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < 1000; i++) {
            System.out.println("i = " + i);
        }
    }

    @Async
    public Future<String> firstTask() throws InterruptedException {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，当前线程：" + Thread.currentThread().getName() + "，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> secondTask() throws InterruptedException {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，当前线程：" + Thread.currentThread().getName() + "，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> thirdTask() throws InterruptedException {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，当前线程：" + Thread.currentThread().getName() + "，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }

    public void getListenableFuture() {
        ListenableFutureTask<String> task = new ListenableFutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000); // 模拟耗时操作
                return "success";
            }
        });
        task.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("调用失败");
            }

            @Override
            public void onSuccess(String s) {
                System.out.println("调用成功：" + s);
            }
        });
        Executors.newSingleThreadExecutor().submit(task);
    }



}
