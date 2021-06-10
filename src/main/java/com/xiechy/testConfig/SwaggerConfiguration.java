package com.xiechy.testConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static cn.hutool.core.collection.CollUtil.newArrayList;


/**
 * @file: SwaggerConfiguration.Class
 * @version:
 * @Description: Swagger配置类-knife4j
 * 代码目的，作用，如何工作
 * @author: 李津
 * @date: 2021-04-13 15:37
 * 本代码要注意的事项、备注事项等
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    //是否允许显示swagger。此值可在application.properties中设定。
    //作为开关，可在生产环境和开发环境打开或关闭，简便易行。
    @Value("${swagger.enable}")
    private boolean swaggerEnable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnable)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()

                //这里一定要标注你控制器的位置
                .apis(RequestHandlerSelectors.basePackage("com.xiechy.code"))
//                .apis(RequestHandlerSelectors.any())

                .paths(PathSelectors.regex("^(?!auth).*$"))

                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                ;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("lj", "https://gitee.com/lijin1998", "lijin2021@foxmail.com");
        return new ApiInfoBuilder()
                .title("李津-admin管理系统API文档")
                .contact(contact)
                .version("1.1")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey("Authorization", "Authorization", "header"));
    }


    private List<SecurityContext> securityContexts() {
        return newArrayList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build()
        );
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("Authorization", authorizationScopes));
    }
}