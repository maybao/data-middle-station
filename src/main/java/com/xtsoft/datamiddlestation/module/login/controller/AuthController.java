package com.xtsoft.datamiddlestation.module.login.controller;

import com.xtsoft.datamiddlestation.common.entity.Result;
import com.xtsoft.datamiddlestation.common.util.ResultUtil;
import com.xtsoft.datamiddlestation.module.login.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author May
 * @date 2021-07-17 14:22
 */
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;


    /**
     * 登录
     */
    @PostMapping(value = "/login")
    public Result<String> login(String username, String password, HttpServletRequest request) throws AuthenticationException {
        // 登录成功会返回Token给用户
        return ResultUtil.success(authService.login(username, password, request));
    }

    @PostMapping(value = "/user/hi")
    public String userHi(String name) throws AuthenticationException {
        return "hi " + name + " , you have 'user' role";
    }

    @PostMapping(value = "/admin/hi")
    public String adminHi(String name) throws AuthenticationException {
        return "hi " + name + " , you have 'admin' role";
    }


}
