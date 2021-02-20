package com.aike.xky.as_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/20 2:50 下午
 */
@JsonIgnoreProperties(value = {"contentMap"})
public class ConfigCenterEntity {
    /**
     * 扩展字段信息
     */
    private Map<String, String> contentMap;
    /**
     * 配置id
     */
    private Integer id;
    /**
     * 配置空间
     */
    private String namespance;
    /**
     * 版本号
     */
    private String version;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 原始配置下载url
     */
    private String originalUrl;
    /**
     * json类型的数据下载地址
     */
    private String jsonUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamespance() {
        return namespance;
    }

    public void setNamespance(String namespance) {
        this.namespance = namespance;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getJsonUrl() {
        return jsonUrl;
    }

    public void setJsonUrl(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }
}
