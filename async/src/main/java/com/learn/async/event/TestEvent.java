package com.learn.async.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author lijy
 * @create 2019-04-11 21:48
 * @description 事件类
 */
@Getter
public class TestEvent extends ApplicationEvent {
    private String msg;

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
