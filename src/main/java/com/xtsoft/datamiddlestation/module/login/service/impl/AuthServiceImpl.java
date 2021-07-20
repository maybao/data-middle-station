package com.xtsoft.datamiddlestation.module.login.service.impl;


import com.xtsoft.datamiddlestation.module.login.service.AuthService;
import com.xtsoft.datamiddlestation.module.login.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author May
 * @date 2021-07-17 14:02
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String login(String username, String password, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // 用户名、密码验证
        Authentication authentication = authenticationManager.authenticate(upToken);
        // 验证通过放入security上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成token
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        Map<String, String> payload = new HashMap<>(10);
        payload.put("username", userDetails.getUsername());
        String accessToken = JwtUtil.getAccessToken(payload);
        String refreshToken = JwtUtil.getRefreshToken(payload);
        request.getSession().setAttribute("refreshToken", refreshToken);
        return accessToken;
    }


}
