package com.xtsoft.datamiddlestation.module.log.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 日志
 * @author May
 * @date 2021/07/20 9:54
 */
@Data
@Accessors(chain = true)
public class LogEntity {
    /**
     * id
     */
    private int id;
    /**
     * 当前时间
     */
    private String currentTime;
    /**
     * 响应时长
     */
    private String responseTime;
    /**
     * 请求url
     */
    private String url;
    /**
     * 请求参数
     */
    private String parameter;
    /**
     * 信息
     */
    private String msg;
}
