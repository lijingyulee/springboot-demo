package com.learn.thread.pojo.thread;

/**
 * @author lijy
 * @create 2019-05-17 7:18
 * @description
 */
public class SafeThread implements Runnable {

    private int ticketCount = 50;

    @Override
    public void run() {
        while (ticketCount > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",出售第" + (50 - ticketCount + 1) + "张票");
            ticketCount--;
        }
    }
}
