package com.aike.xky.as_api.interceptor;

import com.aike.xky.as_api.entity.UserEntity;
import com.aike.xky.as_api.entity.base.ResponseCode;
import com.aike.xky.as_api.entity.base.ResponseEntity;
import com.aike.xky.as_api.interceptor.login.NeedLogin;
import com.aike.xky.as_api.utils.JsonUtils;
import com.aike.xky.as_api.utils.UserRedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/2 5:32 下午
 * 登录拦截器
 */
@Component //必须声明成组件，才能参与扫描和注入
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 请求之前的拦截器
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?> beanType = handlerMethod.getBeanType();//controller
        Method method = handlerMethod.getMethod();//controller-->method
        if (!beanType.isAnnotationPresent(NeedLogin.class) && !method.isAnnotationPresent(NeedLogin.class)) {
            return true;
        }
        //否则当前的请求需要登录
        UserEntity user = UserRedisUtil.getUser(redisTemplate, request);
        if (user != null) {
            //登录过
            return true;
        } else {
            //需要登录哦
            response.setStatus(401);
            response.setContentType("application/json;charset=utf-8");
            ResponseEntity responseEntity = ResponseEntity.of(ResponseCode.RC_MUST_LOGIN);
            response.getWriter().write(JsonUtils.object2Json(responseEntity));
        }
        return false;
    }
}
