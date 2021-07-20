package com.xtsoft.datamiddlestation.module.log.mapper;

import com.xtsoft.datamiddlestation.module.log.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 日志
 * @author May
 * @date 2021/07/20 9:52
 */
@Mapper
public interface LogMapper {
    /**
     * 保存日志
     * @author mayuanbao
     * @date 2021/07/20 9:56
     * @param log log
     */
    void insertLog(@Param("log") LogEntity log);

    /**
     * 查询日志
     * @author mayuanbao
     * @date 2021/07/20 10:11
     * @param id id
     * @return com.xtsoft.datamiddlestation.module.log.entity.LogEntity
     */
    LogEntity selectOne(int id);
}
