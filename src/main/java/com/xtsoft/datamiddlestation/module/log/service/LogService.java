package com.xtsoft.datamiddlestation.module.log.service;

import com.xtsoft.datamiddlestation.module.log.entity.LogEntity;

/**
 * @author May
 * @date 2021/07/20 10:36
 */
public interface LogService {
    /**
     * 保存日志
     * @param log log
     * @return int
     * @author mayuanbao
     * @date 2021/07/20 10:35
     */
    int saveLog(LogEntity log);

    /**
     * 查询日志
     * @param id id
     * @return com.xtsoft.datamiddlestation.module.log.entity.LogEntity
     * @author mayuanbao
     * @date 2021/07/20 10:11
     */
    LogEntity selectOne(int id);
}
