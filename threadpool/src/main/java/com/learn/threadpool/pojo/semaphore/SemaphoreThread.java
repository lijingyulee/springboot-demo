package com.learn.threadpool.pojo.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author lijy
 * @create 2019-05-30 7:46
 * @description
 */
public class SemaphoreThread extends Thread {
    private String name;
    private Semaphore semaphore;

    public SemaphoreThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        if (semaphore.availablePermits() <= 0) {
            System.out.println(name + "等位中。。。");
        }
        try {
            semaphore.acquire();
            System.out.println(name + "开始就餐了。。");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "吃完了。。");
        semaphore.release();
    }
}
