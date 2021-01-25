package com.onway.poseidon.web.controller.user;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onway.poseidon.common.base.response.Response;
import com.onway.poseidon.common.enums.StateEnum;
import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.service.UserService;
import com.onway.poseidon.web.dto.request.user.UserAddRequest;
import com.onway.poseidon.web.dto.request.user.UserLoginRequest;
import com.onway.poseidon.web.dto.request.user.UserPageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author: fuheng
 * @date: 2021/1/21 10:42
 * @description: 用户管理
 */
@Slf4j
@Api(value = "用户管理", tags = {"用户管理"})
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userLoginRequest 登录入参
     * @return 返回登陆结果
     */
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "login", produces = "application/json")
    public Response<Object> login(@RequestBody UserLoginRequest userLoginRequest) {
        log.info("login input:{}", JSON.toJSONString(userLoginRequest));
        try{
            return Response.succeed();
        }catch(Exception e) {
            e.printStackTrace();
            return Response.fail();
        }
    }

    /**
     * 用户列表分页
     * @param userPageRequest 分页查询入参
     * @return 分页数据
     */
    @ApiOperation(value = "用户列表查询")
    @PostMapping(value = "pageList", produces = "application/json")
    public Response<Object> pageList(@RequestBody UserPageRequest userPageRequest) {
        try{
            return Response.succeed();
        }catch (Exception e) {
            e.printStackTrace();
            return Response.fail("查询用户列表失败");
        }
    }

    /**
     * 新增用户
     * @param userAddRequest 新增用户入参
     * @return 返回新增结果
     */
    @ApiOperation(value = "新增用户")
    @PostMapping(value = "add", produces = "application/json")
    public Response<Object> addUser(@Valid @RequestBody UserAddRequest userAddRequest) {
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
