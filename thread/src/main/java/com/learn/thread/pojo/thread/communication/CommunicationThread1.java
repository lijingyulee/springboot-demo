package com.learn.thread.pojo.thread.communication;

import com.learn.thread.pojo.thread.ShareEntity;

/**
 * @author lijy
 * @create 2019-05-28 21:50
 * @description
 */
public class CommunicationThread1 extends Thread{

    private ShareEntity shareEntity;
    public CommunicationThread1(ShareEntity shareEntity) {
        this.shareEntity = shareEntity;
    }

    @Override
    public void run() {
        int num = 0;
        while (true) {
            synchronized (shareEntity) {
                if (shareEntity.getFlag()) {
                    try {
                        shareEntity.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (num % 2 == 0)
                    shareEntity.setName("thread1-set-name-0");
                else
                    shareEntity.setName("thread1-set-name-1");
                num++;
                shareEntity.setFlag(true);
                shareEntity.notify();
            }
        }
    }
}
