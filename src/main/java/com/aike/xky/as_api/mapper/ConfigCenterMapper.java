package com.aike.xky.as_api.mapper;

import com.aike.xky.as_api.entity.ConfigCenterEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigCenterMapper {
    public List<ConfigCenterEntity> queryByNamespace(String namespance);

    public List<ConfigCenterEntity> queryNewAll();

    public void saveConfig(ConfigCenterEntity configCenterEntity);

}
