package com.learn.thread.pojo.thread;

/**
 * @author lijy
 * @create 2019-05-19 8:50
 * @description
 */

    public class LocalThread extends Thread{
        private LocalDemo localDemo;

        public LocalThread(LocalDemo localDemo) {
            this.localDemo = localDemo;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "---" + "i---" + i + "--num:" + localDemo.getNum());
            }
        }
    }
