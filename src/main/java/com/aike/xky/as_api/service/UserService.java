package com.aike.xky.as_api.service;

import com.aike.xky.as_api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void addUser(String user_name, String sex, String enable, String userPhone, String pwd, String createTime) {
        userMapper.addUser(user_name, sex, enable, userPhone, pwd, createTime);
    }
}
