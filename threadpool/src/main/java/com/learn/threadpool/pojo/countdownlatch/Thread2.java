package com.learn.threadpool.pojo.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author lijy
 * @create 2019-05-30 7:15
 * @description
 */
public class Thread2 extends Thread {
    private CountDownLatch countDownLatch;

    public Thread2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread-2");
        countDownLatch.countDown();
    }
}
