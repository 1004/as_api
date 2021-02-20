package com.aike.xky.as_api.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置文件
 * 通过：http://localhost:端口/swagger-ui.html 访问
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket createRestAPi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aike.xky.as_api.controller"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(false)
                .tags(new Tag("Account", "账号模块"))
                .tags(new Tag("ConfigCenter", "配置中心"))
                .tags(new Tag("GoodsCategory","商品分类"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("xky的接口文档")
                .version("1.0.1")
                .contact(new Contact("测试案例", "http://www.baidu.com", "emali@qq.com"))
                .build();
    }
}
