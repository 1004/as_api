package com.aike.xky.as_api.cache;


import java.util.HashMap;
import java.util.Map;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/22 3:28 下午
 */
public class ConfigCacheManager {
    public interface KEY {
        String CONFIG = "config_key";
    }

    private Map<String, Object> mCacheMap = new HashMap<>();
    private static ConfigCacheManager instance = null;
    public  boolean needRefreshConifg = true;

    private ConfigCacheManager() {
    }

    public static ConfigCacheManager getInstance() {
        if (instance == null) {
            synchronized (ConfigCacheManager.class) {
                if (instance == null) {
                    instance = new ConfigCacheManager();
                }
            }
        }
        return instance;
    }

    public void putMemCache(String key, Object value) {
        if (key == null || value == null) {
            return;
        }
        mCacheMap.put(key, value);
    }

    public <T> T getCache(String key, Class<T> tClass) {
        if (key == null) {
            return null;
        }
        Object value = mCacheMap.get(key);
        if (value != null) {
            try {
                return (T) value;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
