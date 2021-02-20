package com.aike.xky.as_api.service;

import com.aike.xky.as_api.entity.ConfigCenterEntity;
import com.aike.xky.as_api.mapper.ConfigCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/20 3:00 下午
 */
@Repository
public class ConfigCenterService {
    @Autowired
    private ConfigCenterMapper centerMapper;

    public List<ConfigCenterEntity> queryByNameSpace(String nameSpace) {
        return centerMapper.queryByNamespace(nameSpace);
    }

    public List<ConfigCenterEntity> queryNewAll() {
        return centerMapper.queryNewAll();
    }
}
