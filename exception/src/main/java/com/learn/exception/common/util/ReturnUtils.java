package com.learn.exception.common.util;

import com.learn.exception.common.bean.Result;
import com.learn.exception.common.bean.ResultCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lijy
 * @create 2019-06-01 20:39
 * @description 返回工具类
 */
@Slf4j
public class ReturnUtils {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result success() {
        return new Result().setCode(ResultCode.SUCCESS)
                .setSuccess(true)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result success(String msg) {
        return new Result().setCode(ResultCode.SUCCESS)
                .setSuccess(true)
                .setMessage(msg);
    }

    public static Result success(String msg, Object data, long totalCount) {
        return new Result().setCode(ResultCode.SUCCESS)
                .setMessage(msg)
                .setData(data)
                .setSuccess(true)
                .setTotalCount(totalCount);
    }

    public static Result fail(String msg) {
        log.error(msg);
        return new Result().setCode(ResultCode.FAIL)
                .setSuccess(false)
                .setMessage(msg);
    }

    public static Result fail(ResultCode code, String msg) {
        log.error(msg);
        return new Result().setCode(code)
                .setSuccess(false)
                .setMessage(msg);
    }

}
