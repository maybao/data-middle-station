package com.xtsoft.datamiddlestation.module.login.filter;


import com.xtsoft.datamiddlestation.module.login.util.JwtUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author May
 * @date 2021-07-17 14:25
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 存放Token的Header Key
     */
    public static final String HEADER_STRING = "token";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader(HEADER_STRING);
        if (StringUtils.isNotEmpty(token)) {
            // 验证令牌
            String username = JwtUtil.getUsername(token);
            if (StringUtils.isNotEmpty(username) && ObjectUtils.isEmpty(SecurityContextHolder.getContext().getAuthentication())) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (JwtUtil.verifyToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            }
        }

        chain.doFilter(request, response);
    }

}
