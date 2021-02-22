package com.aike.xky.as_api.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static SimpleDateFormat sdf_version = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String currentTime() {
        return sdf.format(new Date());
    }

    public static String generateVersion(){
        return sdf_version.format(new Date());
    }
}
