package com.aike.xky.as_api.service;

import com.aike.xky.as_api.cache.ConfigCacheManager;
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
        List<ConfigCenterEntity> centerEntities = centerMapper.queryNewAll();
        if (centerEntities == null) {
            return null;
        }
        for (ConfigCenterEntity entity : centerEntities) {
            ConfigCacheManager.getInstance().putMemCache(getKey(entity.getNamespance()), entity);
        }
        ConfigCacheManager.getInstance().needRefreshConifg = false;
        return centerEntities;
    }

    public void saveConfig(ConfigCenterEntity configCenterEntity) {
        centerMapper.saveConfig(configCenterEntity);
        ConfigCacheManager.getInstance().putMemCache(getKey(configCenterEntity.getNamespance()), configCenterEntity);
    }

    private String getKey(String nameSpace) {
        return nameSpace == null ? ConfigCacheManager.KEY.CONFIG : nameSpace;
    }

}
