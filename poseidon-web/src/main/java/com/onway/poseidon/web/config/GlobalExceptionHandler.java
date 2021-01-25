package com.onway.poseidon.web.config;

import com.onway.poseidon.common.base.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * @author: fuheng
 * @date: 2021/1/25 17:20
 * @description:
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 拦截参数校验失败的异常，获取校验错误信息
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<Object> exceptionHandler(MethodArgumentNotValidException e) {
        return Response.response(Response.BAD_PARAM, Optional.ofNullable(e.getBindingResult().getAllErrors().get(0).getDefaultMessage()).orElse(""));
    }
}
