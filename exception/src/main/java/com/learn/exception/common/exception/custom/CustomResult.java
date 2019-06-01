package com.learn.exception.common.exception.custom;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author lijy
 * @create 2019-06-01 21:52
 * @description 自定义返回结果
 */
public class CustomResult {

    /**
     * 状态响应码
     */
    private String  code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    /**
     * 数据总数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long totalCount;

    public CustomResult setCode(CustomResultCode customResultCode) {
        this.code = customResultCode.code();
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public CustomResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CustomResult setData(Object data) {
        this.data = data;
        return this;
    }

    public Long getTotalCount() { return totalCount;}

    public CustomResult setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

}
