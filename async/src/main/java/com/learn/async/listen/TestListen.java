package com.learn.async.listen;

import com.learn.async.event.TestEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author lijy
 * @create 2019-04-11 21:55
 * @description 监听类
 */
@Component
public class TestListen {
    @EventListener
//    @Async
    public void testListen(TestEvent event) {
        for (int i = 0; i < 10; i++) {
            System.out.println("event = [" + event.getMsg() + "]");
        }
    }
}
