package com.learn.exception.common.exception.custom;

/**
 * @author lijy
 * @create 2019-06-01 21:54
 * @description
 */
public enum CustomResultCode {
    Custom_SUCCESS("1"), //成功
    Custom_Fail("0"); // 失败

    private final String code;

    CustomResultCode(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
