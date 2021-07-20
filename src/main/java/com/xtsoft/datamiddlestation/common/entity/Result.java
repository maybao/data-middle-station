package com.xtsoft.datamiddlestation.common.entity;

/**
 * 结果类
 * @author May
 * @date 2021/06/29 14:18
 */
public class Result<T> {
    /**
     * 返回状态
     */
    private String status;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public Result() {
        super();
    }

    public Result(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
