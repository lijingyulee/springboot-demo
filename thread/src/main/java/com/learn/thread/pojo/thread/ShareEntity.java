package com.learn.thread.pojo.thread;

/**
 * @author lijy
 * @create 2019-05-28 21:45
 * @description 共享变量
 */
public class ShareEntity {
    private String name;
    // 线程通讯标识
    private Boolean flag = false;

    public ShareEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
