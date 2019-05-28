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
//            synchronized (this) {
//                System.out.println(Thread.currentThread().getName() + ",出售第" + (50 - ticketCount + 1) + "张票");
//                ticketCount--;
//            }
//            sale();
            sale2();
        }
    }

    private synchronized void sale() {
        System.out.println(Thread.currentThread().getName() + ",出售第" + (50 - ticketCount + 1) + "张票");
        ticketCount--;
    }


    private void sale2() {
        synchronized (SafeThread.class) {
            System.out.println(Thread.currentThread().getName() + ",出售第" + (50 - ticketCount + 1) + "张票");
            ticketCount--;
        }
    }
}
