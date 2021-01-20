package com.onway.poseidon.service.configration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: fuheng
 * @date: 2020-12-24 22:50
 * @desc: mybatis相关配置
 */
@Configuration
@MapperScan("com.onway.poseidon.service.mapper")
public class MybatisConfig {

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
