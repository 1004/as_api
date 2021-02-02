package com.aike.xky.as_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 */
@RestController
@RequestMapping(value = "/")
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Object helloTest() {
        return "hello world";
    }

}
