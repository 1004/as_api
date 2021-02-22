package com.aike.xky.as_api.cache;

import com.aike.xky.as_api.entity.ConfigCenterEntity;
import com.aike.xky.as_api.utils.JsonUtils;
import com.github.pagehelper.util.StringUtil;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/22 3:53 下午
 */
public class ConfigDelegate {
    public static final String HEADER_CONFIG_KEY = "config";
    public static final String HEADER_CONFIG_NAME_SPACE = "name_space";
    public static final String HEADER_CONFIG_VERSION = "version";

    public static void resBindConfig(Map<String, Object> extra) {
        Map<String, String> configHeader = getConfigHeader();
        if (configHeader == null) {
            return;
        }
        String header_name_space = configHeader.get(HEADER_CONFIG_NAME_SPACE);
        ConfigCenterEntity centerEntity = ConfigCacheManager.getInstance().getCache(header_name_space, ConfigCenterEntity.class);
        if (centerEntity == null) {
            return;
        }
        String version = configHeader.get(HEADER_CONFIG_VERSION);
        if (centerEntity.getNamespance() != null && centerEntity.getNamespance().equals(header_name_space)
                && compareVersion(centerEntity.getVersion(), version)
        ) {
            extra.put(HEADER_CONFIG_KEY, centerEntity);
        }
    }

    private static boolean compareVersion(String v1, String v2) {
        if (v2 == null) {
            return true;
        }
        return v1.compareTo(v2) > 0;
    }

    private static Map<String, String> getConfigHeader() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            String configHeader = request.getHeader(HEADER_CONFIG_KEY);
            if (StringUtil.isEmpty(configHeader)) {
                return null;
            }
            Map<String, String> config = JsonUtils.json2Object(configHeader, Map.class);
            String nameSpace = config.get(HEADER_CONFIG_NAME_SPACE);
            if (StringUtil.isEmpty(nameSpace)) {
                return null;
            }
            return config;
        }
        return null;
    }
}
