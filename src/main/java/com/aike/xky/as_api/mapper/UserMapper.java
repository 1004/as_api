package com.aike.xky.as_api.mapper;

import com.aike.xky.as_api.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    void addUser(String user_name, String sex, String enable, String userPhone, String pwd, String createTime);

    List<UserEntity> queryUserByName(String user_name);
}
