package com.aike.xky.as_api.controller;

import com.aike.xky.as_api.service.UserService;
import com.aike.xky.as_api.utils.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Account"})
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestParam(name = "username") @ApiParam("用户名") String user_name, @RequestParam(name = "sex") @ApiParam("性别：0男，1女") String sex,
                           @RequestParam(name = "enable") @ApiParam("是否主销：0：否，1是") String enable, @RequestParam(name = "phone") @ApiParam("电话") String userPhone, @RequestParam(name = "pwd") @ApiParam("密码") String pwd) {
        userService.addUser(user_name, sex, enable, userPhone, passwordEncoder.encode(pwd), DateUtil.currentTime());
        return "success";
    }
}
