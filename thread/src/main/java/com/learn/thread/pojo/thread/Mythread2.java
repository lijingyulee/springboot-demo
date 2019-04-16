package com.learn.thread.pojo.thread;

/**
 * @author lijy
 * @create 2019-04-16 22:41
 * @description
 */
public class Mythread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
    }
}
