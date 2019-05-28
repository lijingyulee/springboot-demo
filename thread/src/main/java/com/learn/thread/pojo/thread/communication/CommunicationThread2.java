package com.learn.thread.pojo.thread.communication;

import com.learn.thread.pojo.thread.ShareEntity;

/**
 * @author lijy
 * @create 2019-05-28 21:50
 * @description
 */
public class CommunicationThread2 extends Thread{
    private ShareEntity shareEntity;
    public CommunicationThread2(ShareEntity shareEntity) {
        this.shareEntity = shareEntity;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (shareEntity) {
                if (!shareEntity.getFlag()) {
                    try {
                        shareEntity.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(shareEntity.getName());
                shareEntity.setFlag(false);
                shareEntity.notify();
            }
        }
    }
}
