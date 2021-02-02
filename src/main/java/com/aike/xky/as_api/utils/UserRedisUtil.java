package com.aike.xky.as_api.utils;

import com.aike.xky.as_api.entity.UserEntity;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/2 4:58 下午
 */
public class UserRedisUtil {

    private static final String AUTH_TOKEN = "auth_token";


    /**
     * 登录后-添加用户信息到redis
     *
     * @param redisTemplate
     * @param request
     * @param entity
     */
    public static void addUser(StringRedisTemplate redisTemplate, HttpServletRequest request, UserEntity entity) {
        redisTemplate.opsForValue().set(getKey(request.getSession()), JsonUtils.object2Json(entity));
    }

    /**
     * 通过header里获取令牌
     * 缓存删除用户信息
     *
     * @param redisTemplate
     * @param request
     */
    public static void deleteUser(StringRedisTemplate redisTemplate, HttpServletRequest request) {
        request.getSession().invalidate();
        redisTemplate.delete(getToken(request));
    }


    /**
     * 从缓存获取用户
     *
     * @param redisTemplate
     * @param request
     * @return
     */
    public static UserEntity getUser(StringRedisTemplate redisTemplate, HttpServletRequest request) {
        String s = redisTemplate.opsForValue().get(getToken(request));
        if (s != null) {
            return JsonUtils.json2Object(s, UserEntity.class);
        } else {
            return null;
        }
    }


    /**
     * 生成登录令牌
     *
     * @param session
     * @return
     */
    public static String getKey(HttpSession session) {
        return session.getId();
    }

    /**
     * 获取登录令牌
     *
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader(AUTH_TOKEN);
        return token == null ? "token_isvalid" : token;
    }


}
