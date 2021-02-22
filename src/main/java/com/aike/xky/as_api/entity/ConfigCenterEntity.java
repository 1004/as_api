package com.aike.xky.as_api.entity;

import com.aike.xky.as_api.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/20 2:50 下午
 */
@JsonIgnoreProperties(value = {"contentMap"})
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ConfigCenterEntity {
    /**
     * 扩展字段信息
     */
    private Map<String, String> contentMap;
    /**
     * 原始内容
     */
    private String content;
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

    public Map<String, String> getContentMap() {
        return contentMap;
    }

    public void setContentMap(Map<String, String> contentMap) {
        this.contentMap = contentMap;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 生产配置信息
     * 缺少2个uri等待上传cdn后，进行完善
     *
     * @param namespance
     * @param content
     * @return
     */
    public static ConfigCenterEntity of(String namespance, String content) {
        ConfigCenterEntity configCenterEntity = new ConfigCenterEntity();
        configCenterEntity.content = content;
        configCenterEntity.namespance = namespance;
        configCenterEntity.createTime = DateUtil.currentTime();
        configCenterEntity.version = DateUtil.generateVersion();
        configCenterEntity.contentMap = parseContent(content);
        return configCenterEntity;
    }

    private static Map<String, String> parseContent(String content) {
        Map<String, String> temp = new HashMap<>();
        String[] items = content.split("\n");
        for (String item : items) {
            String[] kvs = item.split("=");
            if (kvs.length > 1) {
                temp.put(kvs[0], kvs[1]);
            }
        }
        return temp;
    }

}
