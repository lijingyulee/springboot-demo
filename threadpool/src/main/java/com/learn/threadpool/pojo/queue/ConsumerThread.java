package com.learn.threadpool.pojo.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lijy
 * @create 2019-06-01 9:45
 * @description
 */
public class ConsumerThread implements Runnable {
	private volatile boolean FLAG = true;
	private BlockingQueue<String> blockingQueue;

	public ConsumerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "消费者开始启动....");
		while (FLAG) {
			try {
				String data = blockingQueue.poll(2, TimeUnit.SECONDS);
				if (data == null || data == "") {
					FLAG = false;
					System.out.println("消费者超过2秒时间未获取到消息.");
					return;
				}
				System.out.println("消费者获取到队列信息成功,data:" + data);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
