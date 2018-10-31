package com.onway.poseidon.api.controller;

import com.onway.poseidon.api.dto.request.UserInfoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("getUserInfo")
    public String getUserInfo() {
        redisTemplate.opsForValue().set("name","zhangsan");
        log.info(redisTemplate.opsForValue().get("name").toString());
        UserInfoRequest userInfoRequest = UserInfoRequest.builder().method("getUserInfo").build();
        log.info(userInfoRequest.toString());
        return "zhangsan";
    }

}
