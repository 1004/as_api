package com.aike.xky.as_api.interceptor;

import com.aike.xky.as_api.cache.ConfigCacheManager;
import com.aike.xky.as_api.service.ConfigCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/22 3:51 下午
 */
@Component
public class CommonInterceptor implements HandlerInterceptor {
    @Autowired
    private ConfigCenterService centerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (ConfigCacheManager.getInstance().needRefreshConifg) {
            centerService.queryNewAll();
        }
        return true;
    }
}
