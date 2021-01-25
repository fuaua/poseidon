package com.onway.poseidon.web.config;
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
                .groupName("web")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.onway.poseidon.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("poseidon-web接口文档")
                .description("poseidon-web后台服务API接口文档")
                .termsOfServiceUrl("http://localhost:8080/")
                .contact(new Contact("henry", "", ""))
                .version("1.0.0")
                .build();
    }
}