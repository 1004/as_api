package com.aike.xky.as_api.controller;

import com.aike.xky.as_api.entity.UserEntity;
import com.aike.xky.as_api.entity.base.ResponseCode;
import com.aike.xky.as_api.entity.base.ResponseEntity;
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

import java.util.List;

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
    public ResponseEntity register(@RequestParam(name = "username") @ApiParam("用户名") String user_name, @RequestParam(name = "sex") @ApiParam("性别：0男，1女") String sex,
                                   @RequestParam(name = "enable") @ApiParam("是否主销：0：否，1是") String enable, @RequestParam(name = "phone") @ApiParam("电话") String userPhone, @RequestParam(name = "pwd") @ApiParam("密码") String pwd) {
        userService.addUser(user_name, sex, enable, userPhone, passwordEncoder.encode(pwd), DateUtil.currentTime());
        return ResponseEntity.of(ResponseCode.RC_SUCCESS);
    }

    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestParam(name = "username") @ApiParam("用户名") String user_name, @RequestParam(name = "pwd") @ApiParam("密码") String pwd) {
        List<UserEntity> userEntities = userService.queryUserByName(user_name);
        if (userEntities == null || userEntities.isEmpty()) {
            return ResponseEntity.of(ResponseCode.RC_ACCOUNT_INVALID);
        }
        UserEntity userEntity = null;
        for (UserEntity entity : userEntities) {
            if (passwordEncoder.matches(pwd, entity.getPwd())) {
                userEntity = entity;
                break;
            }
        }
        if (userEntity == null) {
            return ResponseEntity.of(ResponseCode.RC_PWD_INVALID);
        }
        //用户是否已经注销
        if ("0".equals(userEntity.getUserEnable())) {
            return ResponseEntity.of(ResponseCode.RC_USER_FORBIND);
        }
        return ResponseEntity.success(userEntity);
    }

}
