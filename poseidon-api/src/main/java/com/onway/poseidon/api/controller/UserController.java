package com.onway.poseidon.api.controller;

import com.onway.poseidon.common.base.Response;
import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserService userService;

    @RequestMapping("getUserInfo")
    public Response getUserInfo() {
        User user = userService.selectById(1L);
        return Response.succeed(user);
    }

}
