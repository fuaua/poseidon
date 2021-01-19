package com.onway.poseidon.api.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * knife4j 配置
 * @Author henry
 */
@Configuration
@EnableSwagger2
public class Knife4jConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.onway.poseidon.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("poseidon接口文档")
                .description("使用 knife4j 搭建的后台服务API接口文档")
                .termsOfServiceUrl("http://localhost:8083/api")
                .contact(new Contact("henry", "", ""))
                .version("1.0.0")
                .build();
    }
}