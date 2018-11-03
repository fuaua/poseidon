package com.onway.poseidon.api.controller;

import com.onway.poseidon.api.dto.request.UserInfoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fuheng
 * @date: 2018-10-24 23:09
 * @desc: 功能描述
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @RequestMapping("getUserInfo")
    public String getUserInfo() {
        log.debug("debug用户信息====");
        log.info("info获取用户信息===============");
        log.warn("warn用户====");
        log.error("error出错了");
        UserInfoRequest userInfoRequest = UserInfoRequest.builder().method("getUserInfo").build();
        return "zhangsan";
    }

}
