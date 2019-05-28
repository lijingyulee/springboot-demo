package com.learn.thread.controller;

import com.learn.thread.pojo.thread.*;
import com.learn.thread.pojo.thread.communication.CommunicationThread1;
import com.learn.thread.pojo.thread.communication.CommunicationThread2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijy
 * @create 2019-04-16 22:31
 * @description
 */
@RestController
public class MyThreadController {

    @GetMapping("test-my-thread")
    public void testMyThead() {
        MyThread myThread = new MyThread();
        System.out.println("start thread");
        myThread.start();
        System.out.println("end thread");
    }

    @GetMapping("test-my-thread2")
    public void testMyThead2() {
        Mythread2 mythread2 = new Mythread2();
        System.out.println("start thread");
        new Thread(mythread2).start();
        System.out.println("end thread");
    }

    @GetMapping("test-my-thread3")
    public void testMyThead3() {
        new Thread(() -> {
            System.out.println("start thread");
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }
            System.out.println("end thread");
        }).start();
    }

    @RequestMapping("test-join")
    public void testJoin() throws InterruptedException {
        System.out.println("主线程start");
        Thread thread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("i = " + i);
            }
        });
        thread.start();
        thread.join();
        for (int j = 0; j < 100; j++) {
            System.out.println("j = " + j);
        }
        System.out.println("主线程end");

    }

    @RequestMapping("test-safe")
    public void testSafe() {
        SafeThread safeThread = new SafeThread();
        Thread t1 = new Thread(safeThread, "thread-1");
        Thread t2 = new Thread(safeThread, "thread-2");
        t1.start();
        t2.start();
    }

    @RequestMapping("test-local")
    public void testLocal() {
        LocalDemo localDemo = new LocalDemo();
        LocalThread lt1 = new LocalThread(localDemo);
        LocalThread lt2 = new LocalThread(localDemo);
        LocalThread lt3 = new LocalThread(localDemo);
        lt1.start();
        lt2.start();
        lt3.start();
    }

    @RequestMapping("test-communication")
    public void testCommunication() {
        ShareEntity shareEntity = new ShareEntity();
        CommunicationThread1 thread1 = new CommunicationThread1(shareEntity);
        CommunicationThread2 thread2 = new CommunicationThread2(shareEntity);
        thread1.start();
        thread2.start();
    }

}
