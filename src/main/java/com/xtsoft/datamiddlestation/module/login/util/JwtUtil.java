package com.xtsoft.datamiddlestation.module.login.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xtsoft.datamiddlestation.module.login.entity.TokenProperties;
import com.xtsoft.datamiddlestation.module.login.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * jwt工具类
 * @author May
 * @date 2020/11/10 10:58
 */
public class JwtUtil {
    /**
     * 默认签名
     */
    private static String SIGNATURE;
    /**
     * access_token 过期时间，单位为分钟，只能取整数，默认120分钟
     */
    private static Integer ACCESS_EXPIRE_TIME;
    /**
     * refresh_token 过期时间，单位为分钟，默认360小时
     */
    private static Integer REFRESH_EXPIRE_TIME;

    public JwtUtil() {
    }

    /**
     * 获取配置文件中的signature与expireTime并赋值给SIGNATURE与EXPIRETIME
     */
    public JwtUtil(TokenProperties tokenProperties) {
        SIGNATURE = tokenProperties.getSignature();
        ACCESS_EXPIRE_TIME = tokenProperties.getAccessExpireTime();
        REFRESH_EXPIRE_TIME = tokenProperties.getRefreshExpireTime();
    }

    /**
     * 生成 accessToken，header.payload.signature
     * @param payload payload
     * @return java.lang.String
     * @author mayuanbao
     * @date 2020/11/10 11:09
     */
    public static String getAccessToken(Map<String, String> payload) {
        return new JwtUtil().getToken(payload, ACCESS_EXPIRE_TIME);
    }

    /**
     * 生成 refreshToken
     * @param payload payload
     * @return java.lang.String
     * @author mayuanbao
     * @date 2020/11/11 16:54
     */
    public static String getRefreshToken(Map<String, String> payload) {
        return new JwtUtil().getToken(payload, REFRESH_EXPIRE_TIME);
    }

    /**
     * 生成 token
     * @param payload    payload
     * @param expireTime expireTime
     * @return java.lang.String
     * @author mayuanbao
     * @date 2020/11/11 16:54
     */
    private String getToken(Map<String, String> payload, Integer expireTime) {
        // 设置过期时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, expireTime);
        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        // 遍历添加payload
        payload.forEach(builder::withClaim);
        return builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SIGNATURE));
    }

    /**
     * 验证token
     * @param token       token
     * @param userDetails userDetails
     * @author mayuanbao
     * @date 2020/11/10 11:25
     */
    public static Boolean verifyToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        String username = getUsername(token);
        return (Objects.equals(username, user.getUsername()) && !isTokenExpired(token));
    }

    /**
     * 验证token是否过期
     * @param token token
     * @return java.lang.Boolean
     * @author mayuanbao
     * @date 2021/07/19 9:51
     */
    public static Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDate(token);
        return expiration.before(new Date());
    }

    /**
     * 验证token
     * @param token token
     * @author mayuanbao
     * @date 2020/11/10 11:25
     */
    public static DecodedJWT verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }

    /**
     * 获取token过期时间
     * @param token token
     * @return java.util.Date
     * @author mayuanbao
     * @date 2021/07/19 9:49
     */
    public static Date getExpirationDate(String token) {
        DecodedJWT jwt = verifyToken(token);
        return jwt.getExpiresAt();
    }

    /**
     * 解析token，获取用户名
     * @param token token
     * @return 用户名
     * @author mayuanbao
     * @date 2020/12/14 13:54
     */
    public static String getUsername(String token) {
        DecodedJWT jwt = verifyToken(token);
        return jwt.getClaim("username").asString();
    }
}
