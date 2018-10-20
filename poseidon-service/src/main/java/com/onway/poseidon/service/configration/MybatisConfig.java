package com.onway.poseidon.service.configration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: fuheng
 * @date: 2018-10-20 12:43
 * @desc: 功能描述
 */
@Configuration
@MapperScan("com.onway.poseidon.service.mapper")
public class MybatisConfig {
}
