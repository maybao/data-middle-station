package com.xtsoft.datamiddlestation.module.log.controller;

import com.xtsoft.datamiddlestation.common.entity.Result;
import com.xtsoft.datamiddlestation.common.util.ResultUtil;
import com.xtsoft.datamiddlestation.module.log.entity.LogEntity;
import com.xtsoft.datamiddlestation.module.log.service.LogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日志
 * @author May
 * @date 2021/07/20 10:41
 */
@RestController
@RequestMapping("/log")
public class LogController {
    @Resource
    private LogService logService;

    /**
     * 查询日志
     * @param id id
     * @return 日志信息
     * @author mayuanbao
     * @date 2021/07/20 10:11
     */
    @PostMapping("/selectOne")
    public Result<LogEntity> selectOne(int id) {
        return ResultUtil.success(logService.selectOne(id));
    }
}
