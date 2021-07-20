package com.xtsoft.datamiddlestation.module.login.mapper;

import com.xtsoft.datamiddlestation.module.login.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限
 * @author mayuanbao
 * @date 2021/07/17 15:40
 */
@Mapper
public interface PermissionMapper {

    /**
     * 获取角色对应的权限
     * @author mayuanbao
     * @date 2021/07/17 16:06
     * @return java.util.List<com.xtsoft.dmp.module.login.entity.RolePermission>
     */
    @Select( "SELECT A.NAME AS roleName,C.url FROM role AS A LEFT JOIN role_permission B ON A.id=B.role_id LEFT JOIN permission AS C ON B.permission_id=C.id" )
    List<RolePermission> getRolePermissions();

}
