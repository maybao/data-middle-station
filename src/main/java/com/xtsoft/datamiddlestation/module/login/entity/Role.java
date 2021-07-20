package com.xtsoft.datamiddlestation.module.login.entity;


import org.springframework.security.core.GrantedAuthority;

/**
 * 角色
 * @author mayuanbao
 * @date 2021/07/17 15:35
 */
public class Role implements GrantedAuthority {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
