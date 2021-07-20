package com.xtsoft.datamiddlestation.module.login.service.impl;


import com.xtsoft.datamiddlestation.module.login.entity.Role;
import com.xtsoft.datamiddlestation.module.login.entity.User;
import com.xtsoft.datamiddlestation.module.login.mapper.RoleMapper;
import com.xtsoft.datamiddlestation.module.login.mapper.UserMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayuanbao
 * @date 2021/07/17 16:09
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查数据库
        User user = userMapper.loadUserByUsername(userName);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Role> roles = roleMapper.getRolesByUserId(user.getId());
        user.setAuthorities(roles);
        return user;
    }
}
