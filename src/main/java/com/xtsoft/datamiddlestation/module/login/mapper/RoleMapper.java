package com.xtsoft.datamiddlestation.module.login.mapper;

import com.xtsoft.datamiddlestation.module.login.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 获取角色
 * @author mayuanbao
 * @date 2021/07/17 16:12
 */
@Mapper
public interface RoleMapper {

    /**
     * 获取角色
     * @author mayuanbao
     * @date 2021/07/17 16:07
     * @param userId userId
     * @return java.util.List<com.xtsoft.dmp.module.login.entity.Role>
     */
    @Select( "SELECT A.id,A.name FROM role A LEFT JOIN user_role B ON A.id=B.role_id WHERE B.user_id=${userId}" )
    List<Role> getRolesByUserId(@Param("userId") Long userId);

}
