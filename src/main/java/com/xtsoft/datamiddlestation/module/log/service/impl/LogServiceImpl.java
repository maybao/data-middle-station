package com.xtsoft.datamiddlestation.module.log.service.impl;

import com.xtsoft.datamiddlestation.module.log.entity.LogEntity;
import com.xtsoft.datamiddlestation.module.log.mapper.LogMapper;
import com.xtsoft.datamiddlestation.module.log.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 日志
 * @author May
 * @date 2021/07/20 10:27
 */
@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogMapper logMapper;

    /**
     * 保存日志
     * @param log log
     * @return int
     * @author mayuanbao
     * @date 2021/07/20 10:35
     */
    @Override
    public int saveLog(LogEntity log) {
        logMapper.insertLog(log);
        return log.getId();
    }

    /**
     * 查询日志
     * @param id id
     * @return com.xtsoft.datamiddlestation.module.log.entity.LogEntity
     * @author mayuanbao
     * @date 2021/07/20 10:11
     */
    @Override
    public LogEntity selectOne(int id) {
        return logMapper.selectOne(id);
    }
}
