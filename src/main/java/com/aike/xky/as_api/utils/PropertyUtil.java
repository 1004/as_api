package com.aike.xky.as_api.utils;

import org.springframework.boot.system.ApplicationHome;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/22 2:56 下午
 */
public class PropertyUtil {
    public static String getDocPath(String append) {
        return new ApplicationHome(ConfigCenterFileUtils.class).getSource()
                .getParentFile().getParentFile().getPath() + "/" + append;
    }

    public static String getCNDPrefix(String append) {
        return "http://10.36.210.8:8080/as/" + append;
    }
}
