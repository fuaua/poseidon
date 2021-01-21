package com.onway.poseidon.web.controller.user;

import com.alibaba.fastjson.JSON;
import com.netflix.discovery.converters.Auto;
import com.onway.poseidon.common.base.Response;
import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.service.UserService;
import com.onway.poseidon.web.dto.request.UserListRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fuheng
 * @date: 2021/1/21 10:42
 * @description: 用户管理
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "userList", method = RequestMethod.POST, produces = "application/json")
    public Response userList(@RequestBody UserListRequest userListRequest){
        log.info("userList input:{}", JSON.toJSON(userListRequest));
        User user = userService.getById(1L);
        return Response.succeed(user);
    }

}
