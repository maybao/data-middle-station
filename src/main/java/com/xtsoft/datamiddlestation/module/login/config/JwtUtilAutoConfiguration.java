package com.xtsoft.datamiddlestation.module.login.config;

import com.xtsoft.datamiddlestation.module.login.entity.TokenProperties;
import com.xtsoft.datamiddlestation.module.login.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author May
 * @date 2020/12/04 11:39
 */
@Configuration
@EnableConfigurationProperties(TokenProperties.class)
public class JwtUtilAutoConfiguration {

    @Autowired
    private TokenProperties tokenProperties;

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(tokenProperties);
    }
}
