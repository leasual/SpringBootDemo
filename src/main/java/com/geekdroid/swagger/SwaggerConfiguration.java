package com.geekdroid.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by james.li on 2017/3/2.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.geekdroid.controller"))//要扫描的API(Controller)基础包
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo buildApiInfo(){
        return new ApiInfoBuilder()
                .title("Spring boot 使用Swagger2 UI构建API文档")
                .contact("风紧，扯呼")
                .version("1.0")
                .build();
    }
}
