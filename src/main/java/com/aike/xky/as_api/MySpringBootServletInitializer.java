package com.aike.xky.as_api;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/4 3:28 下午
 */
public class MySpringBootServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AsApiApplication.class);
    }
}
