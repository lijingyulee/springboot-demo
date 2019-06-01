package com.learn.threadpool.controller;

import com.learn.threadpool.pojo.countdownlatch.Thread1;
import com.learn.threadpool.pojo.countdownlatch.Thread2;
import com.learn.threadpool.pojo.queue.ConsumerThread;
import com.learn.threadpool.pojo.queue.ProducerThread;
import com.learn.threadpool.pojo.semaphore.SemaphoreThread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @author lijy
 * @create 2019-05-30 7:12
 * @description
 */
@RestController
public class ThreadPoolController {

    @RequestMapping("test-countdownlatch")
    public void testCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread1 thread1 = new Thread1(countDownLatch);
        Thread2 thread2 = new Thread2(countDownLatch);
        thread1.start();
        thread2.start();
        try {
            countDownLatch.await();
            System.out.println("main...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("test-semaphore")
    public void testSemaphore() {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 1; i <= 3; i++) {
            new SemaphoreThread("第" + i + "个人", semaphore).start();
        }
    }

    @RequestMapping("test-clq")
    public void testConcurrentLinkedQueue() {
        ConcurrentLinkedDeque<String> q = new ConcurrentLinkedDeque<>();
        q.offer("Java");
        q.offer("C#");
        q.offer("Javascript");
        q.offer("Python");
        // 从头获取元素,删除该元素
        System.out.println(q.poll());
        // 从头获取元素,不刪除该元素
        System.out.println(q.peek());
        // 获取总长度
        System.out.println(q.size());
        // 遍历
        for (String s : q) {
            System.out.println(s);
        }
    }

    @RequestMapping("test-blockingQueue")
    public void testBlockingQueue() {
        LinkedBlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(1);
        ProducerThread producerThread = new ProducerThread(blockingDeque);
        ConsumerThread consumerThread = new ConsumerThread(blockingDeque);
        Thread t1 = new Thread(producerThread, "生产者");
        Thread t2 = new Thread(consumerThread, "消费者");
        t1.start();
        t2.start();

        // 10秒后停止线程
        try {
            Thread.sleep(10 * 1000);
            producerThread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("test-threadpool")
    public void testThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                6,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3));

        for (int i = 0; i < 6; i++) {
            TaskThred t1 = new TaskThred("任务" + i);
            threadPoolExecutor.execute(t1);
        }
        threadPoolExecutor.shutdown();
    }

}
class TaskThred implements Runnable {
    private String taskName;

    public TaskThred(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+taskName);
    }

}

