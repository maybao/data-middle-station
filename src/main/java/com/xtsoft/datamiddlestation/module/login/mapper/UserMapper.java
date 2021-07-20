package com.xtsoft.datamiddlestation.module.login.mapper;

import com.xtsoft.datamiddlestation.module.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户
 * @author mayuanbao
 * @date 2021/07/19 11:25
 */
@Mapper
public interface UserMapper {

    /**
     * 查询用户
     * @author mayuanbao
     * @date 2021/07/17 16:08
     * @param username username
     * @return com.xtsoft.dmp.module.login.entity.User
     */
    @Select( "select id , username , password from user where username = #{username}" )
    User loadUserByUsername(@Param("username") String username);

}
