package com.aike.xky.as_api.service;

import com.aike.xky.as_api.entity.UserEntity;
import com.aike.xky.as_api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册添加用户
     *
     * @param user_name
     * @param sex
     * @param enable
     * @param userPhone
     * @param pwd
     * @param createTime
     */
    public void addUser(String user_name, String sex, String enable, String userPhone, String pwd, String createTime) {
        userMapper.addUser(user_name, sex, enable, userPhone, pwd, createTime);
    }

    /**
     * 查询用户根据名字
     *
     * @param user_name
     * @return
     */
    public List<UserEntity> queryUserByName(String user_name) {
        return userMapper.queryUserByName(user_name);
    }
}
