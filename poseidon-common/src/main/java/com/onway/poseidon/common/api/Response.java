package com.onway.poseidon.common.api;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: fuheng
 * @date: 2020/12/28 16:42
 * @description: 接口通用返回类
 */
@Data
public class Response<T> implements Serializable {

    public static final Integer SUCCESS = 200;

    public static final String SUCCESS_MSG = "操作成功";

    public static final Integer FAIL = 400;

    public static final String FAIL_MSG = "操作失败";

    public Response() {

    }

    public Response(Integer code, String msg, T payload) {
        this.code = code;
        this.msg = msg;
        this.payload = payload;
    }

    private Integer code;

    private String msg;

    private T payload;

    public static Response SUCCESS() {
        return new Response(SUCCESS, SUCCESS_MSG, "");
    }

    public static <T> Response<T> SUCCESS(T payload) {
        return new Response(SUCCESS, SUCCESS_MSG, payload);
    }

    public static <T> Response<T> SUCCESS(Integer code, String msg, T payload) {
        return new Response<>(code, msg, payload);
    }

    public static Response FAIL() {
        return new Response(FAIL, FAIL_MSG, "");
    }

    public static Response FAIL(String msg) {
        return new Response(FAIL, msg, "");
    }
}
