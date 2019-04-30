package com.onway.poseidon.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: fuheng
 * @date: 2018-10-24 22:50
 * @desc: 功能描述
 */
@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan("com.onway.poseidon")
public class ApiApplication {

    public static void main(String[] args){
        SpringApplication.run(ApiApplication.class, args);
    }

}
