package com.onway.poseidon.web;


import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fuheng
 * @date: 2018-10-11 22:45
 * @desc: 功能描述
 */
@SpringBootApplication
@RestController
@ComponentScan("com.onway.poseidon")
public class WebApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args){
        SpringApplication.run(WebApplication.class, args);
    }

    @RequestMapping("/poseidon")
    public String getUserById() {
        User user = userService.selectById(1L);
        return user.toString();
    }


}
