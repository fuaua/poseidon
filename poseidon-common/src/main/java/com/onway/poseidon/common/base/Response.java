package com.onway.poseidon.common.base;

import lombok.Data;

/**
 * @author: fuheng
 * @date: 2019-02-25 21:33
 * @desc: 接口通信返回数据基类
 */
@Data
public class Response<T> {

    /**
     * 返回成功码值
     */
    private static final Long SUCCESS_CODE = 200L;

    /**
     * 成功默认返回语
     */
    private static final String SUCCESS_MESSAGE = "操作成功";

    /**
     * 错误的请求
     */
    private static final Long BAD_REQUEST = 400L;

    /**
     * 错误的请求返回语
     */
    private static final String BAD_REQUEST_MESSAGE = "错误的请求";


    /**
     * code编码
     */
    private Long code;

    /**
     * 返回的消息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T payload;


    Response(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    Response(Long code, String message, T payload) {
        this.code = code;
        this.message = message;
        this.payload = payload;
    }

    public static Response<Object> succeed() {
        return new Response<>(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static <T> Response<T> succeed(T payload) {
        return new Response<>(SUCCESS_CODE, SUCCESS_MESSAGE, payload);
    }

    public static Response<Object> fail() {
        return new Response<>(BAD_REQUEST, BAD_REQUEST_MESSAGE);
    }

    public static Response<Object> fail(String msg) {
        return new Response<>(BAD_REQUEST, msg);
    }

    public static Response<Object> response(Long code, String message) {
        return new Response<>(code, message);
    }

}
