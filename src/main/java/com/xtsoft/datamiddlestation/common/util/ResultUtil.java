package com.xtsoft.datamiddlestation.common.util;


import com.xtsoft.datamiddlestation.common.entity.Result;
import com.xtsoft.datamiddlestation.common.enums.ResultEnum;

/**
 * 返回结果集
 * @author May
 * @date 2021/06/29 14:25
 */
public class ResultUtil {

    /**
     * 成功-带数据
     * @author mayuanbao
     * @date 2021/06/29 14:52
     * @param obj 返回数据
     * @return com.qyd.module.common.entity.Result<T>
     */
    public static<T> Result<T> success(T obj){
        Result<T> result = new Result<>();
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(obj);
        return result;
    }

    /**
     * 成功-带数据-自定义信息
     * @author mayuanbao
     * @date 2021/06/29 14:52
     * @param obj 返回数据
     * @param msg msg
     * @return com.qyd.module.common.entity.Result<T>
     */
    public static<T> Result<T> success(T obj, String msg){
        Result<T> result = new Result<>();
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }
    /**
     * 成功-不带数据
     * @author mayuanbao
     * @date 2021/06/29 14:53
     * @return com.qyd.module.common.entity.Result<T>
     */
    public static<T> Result<T> success(){
        return success(null);
    }
    /**
     * 失败-自定义信息
     * @author mayuanbao
     * @date 2021/06/29 14:53
     * @param msg 返回信息
     * @return com.qyd.module.common.entity.Result<T>
     */
    public static<T> Result<T> error(String msg){
        Result<T> result = new Result<>();
        result.setStatus(ResultEnum.ERROR.getStatus());
        result.setMsg(msg);
        return result;
    }

    /**
     * 失败-默认信息
     * @author mayuanbao
     * @date 2021/06/29 14:53
     * @return com.qyd.module.common.entity.Result<T>
     */
    public static<T> Result<T> error(){
        Result<T> result = new Result<>();
        result.setStatus(ResultEnum.ERROR.getStatus());
        result.setMsg(ResultEnum.ERROR.getMsg());
        return result;
    }

    /**
     * 失败-带结果
     * @author mayuanbao
     * @date 2021/06/29 14:53
     * @return com.qyd.module.common.entity.Result<T>
     */
    public static<T> Result<T> error(T obj){
        Result<T> result = new Result<>();
        result.setStatus(ResultEnum.ERROR.getStatus());
        result.setMsg(ResultEnum.ERROR.getMsg());
        result.setData(obj);
        return result;
    }

    /**
     * 失败-自定义信息、结果
     * @author mayuanbao
     * @date 2021/06/29 14:53
     * @return com.qyd.module.common.entity.Result<T>
     */
    public static<T> Result<T> error(String msg, T obj){
        Result<T> result = new Result<>();
        result.setStatus(ResultEnum.ERROR.getStatus());
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }
}