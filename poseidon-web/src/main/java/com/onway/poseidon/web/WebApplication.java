package com.onway.poseidon.web;

import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: fuheng
 * @date: 2018-10-11 22:45
 * @desc: 功能描述
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@ComponentScan("com.onway.poseidon")
@Slf4j
public class WebApplication {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args){
        SpringApplication.run(WebApplication.class, args);
    }

    @RequestMapping("/poseidon")
    public String getUserById() {
        String temp = restTemplate.postForObject("http://poseidon-api/api/getUserInfo", null, String.class);
        User user = userService.selectById(2L);
        log.info(temp);
        log.error(user.getUserpass());
        return "string";
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
