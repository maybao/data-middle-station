package com.xtsoft.datamiddlestation.module.login.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author mayuanbao
 * @date 2020-11-10 20:50
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class TokenProperties {
    /**
     * 签名,默认：xtSoft
     */
    private String signature = "xtSoft";
    /**
     * accessToken 过期时间，单位为分，默认2小时
     */
    private Integer accessExpireTime = 120;
    /**
     * refreshToken 过期时间，单位为分，默认6小时
     */
    private Integer refreshExpireTime = 360;


    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getAccessExpireTime() {
        return accessExpireTime;
    }

    public void setAccessExpireTime(Integer accessExpireTime) {
        this.accessExpireTime = accessExpireTime;
    }

    public Integer getRefreshExpireTime() {
        return refreshExpireTime;
    }

    public void setRefreshExpireTime(Integer refreshExpireTime) {
        this.refreshExpireTime = refreshExpireTime;
    }
}
