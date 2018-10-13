package com.onway.poseidon.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fuheng
 * @date: 2018-10-11 22:45
 * @desc: 功能描述
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/poseidon")
    public String getUserById() {
        System.out.println("sadfasd");
        return "zhangsan";
    }


}
