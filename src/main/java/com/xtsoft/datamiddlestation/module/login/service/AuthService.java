package com.xtsoft.datamiddlestation.module.login.service;


import javax.servlet.http.HttpServletRequest;

/**
 * @author May
 * @date 2021-07-17 14:47
 */
public interface AuthService {

    /**
     * 登陆
     * @param username username
     * @param password password
     * @param request request
     * @return java.lang.String
     * @author mayuanbao
     * @date 2021/07/17 14:48
     */
    String login(String username, String password, HttpServletRequest request);

}

