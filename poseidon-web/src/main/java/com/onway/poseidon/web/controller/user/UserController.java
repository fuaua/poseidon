package com.onway.poseidon.web.controller.user;

import com.alibaba.fastjson.JSON;
import com.onway.poseidon.common.base.Response;
import com.onway.poseidon.common.enums.StateEnum;
import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.service.UserService;
import com.onway.poseidon.web.dto.request.user.UserAddRequest;
import com.onway.poseidon.web.dto.request.user.UserLoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

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

    /**
     * 用户登录
     * @param userLoginRequest
     * @return
     */
    @PostMapping(value = "login", produces = "application/json")
    public Response<Object> login(@RequestBody UserLoginRequest userLoginRequest) {
        try{
            return Response.succeed();
        }catch(Exception e) {
            e.printStackTrace();
            return Response.fail();
        }
    }

    /**
     * 新增用户
     * @param userAddRequest
     * @return
     */
    @PostMapping(value = "add", produces = "application/json")
    public Response<Object> userList(@RequestBody UserAddRequest userAddRequest) {
        log.info("user add input:{}", JSON.toJSON(userAddRequest));
        try{
            User user = User.builder()
                    .loginName(userAddRequest.getLoginName())
                    .userName(userAddRequest.getUserName())
                    .userPass(userAddRequest.getUserPass())
                    .createTime(new Date())
                    .state(StateEnum.VALID.getValue())
                    .build();
            userService.add(user);
            return Response.succeed();
        }catch (Exception e) {
            e.printStackTrace();
            return Response.fail("新增用户异常");
        }
    }

}
