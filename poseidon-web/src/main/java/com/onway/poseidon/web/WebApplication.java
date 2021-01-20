package com.onway.poseidon.web;


import com.onway.poseidon.common.base.Response;
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
import org.springframework.web.client.RestTemplate;

/**
 * @author: fuheng
 * @date: 2020-12-24 22:50
 * @desc: 功能描述
 */
@SpringBootApplication
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
    public Response getUserById() {
        String s = restTemplate.postForObject("http://poseidon-api/api/getUserInfo", Response.class, String.class);
        return Response.succeed(s);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
