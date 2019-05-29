package com.learn.threadpool.pojo.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author lijy
 * @create 2019-05-30 7:13
 * @description
 */
public class Thread1 extends Thread {
    private CountDownLatch countDownLatch;
    public Thread1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread-1");
        countDownLatch.countDown();
    }
}
