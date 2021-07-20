package com.xtsoft.datamiddlestation.common.enums;

/**
 * @author May
 * @date 2021/06/29 14:21
 */
public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    //未知错误
    SYS_ERROR("failed", "系统异常，请联系管理员！"),
    USER_NOT_FOUND("failed", "用户不存在"),
    PASSWORD_ERROR("failed","密码错误"),
    LOGIN_ERROR("failed", "登陆异常，请联系管理员！"),
    TOKEN_EXPIRED("failed", "用户登录已过期"),
    SUCCESS("success", "成功"),
    ERROR("failed", "失败");

    private final String status;
    private final String msg;

    ResultEnum(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}