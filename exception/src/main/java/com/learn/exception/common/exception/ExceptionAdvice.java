package com.learn.exception.common.exception;

import com.learn.exception.common.bean.Result;
import com.learn.exception.common.bean.ResultCode;
import com.learn.exception.common.util.ReturnUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lijy
 * @create 2019-06-01 20:29
 * @description 全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpServletResponse resp, Exception e) {
        log.error(e.getMessage());
        return ReturnUtils.fail(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
