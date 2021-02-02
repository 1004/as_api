package com.aike.xky.as_api.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void addUser(String user_name, String sex, String enable, String userPhone, String pwd, String createTime);
}
