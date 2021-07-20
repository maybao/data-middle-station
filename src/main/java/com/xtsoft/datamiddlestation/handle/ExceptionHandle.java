package com.xtsoft.datamiddlestation.handle;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.xtsoft.datamiddlestation.common.entity.Result;
import com.xtsoft.datamiddlestation.common.enums.ResultEnum;
import com.xtsoft.datamiddlestation.common.util.ResultUtil;
import com.xtsoft.datamiddlestation.module.log.entity.LogEntity;
import com.xtsoft.datamiddlestation.module.log.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * 统一异常处理
 * @author mayuanbao
 * @date 2019-06-04 20:44
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {
    @Resource
    private LogService logService;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Object> handle(HttpServletRequest request, Exception e) {

        if (e instanceof TokenExpiredException) {
            return ResultUtil.error(ResultEnum.TOKEN_EXPIRED.getMsg());
        } else if (e instanceof JWTVerificationException) {
            return ResultUtil.error(ResultEnum.LOGIN_ERROR.getMsg());
        } else if (e instanceof BadCredentialsException) {
            return ResultUtil.error(ResultEnum.PASSWORD_ERROR.getMsg());
        } else {
            // 组装请求参数
            Enumeration<String> parameterNames = request.getParameterNames();
            StringBuilder sb = new StringBuilder();
            int i = 1;
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                String value = request.getParameter(name);
                if (i == 1) {
                    sb.append(name).append("=").append(value);
                } else {
                    sb.append(",").append(name).append("=").append(value);
                }
                i++;
            }
            // 获取异常信息
            String expInfo = getExceptionInfo(e);
            log.error("******************【RequestBeginning】********************");
            log.error("----------------StartProcessingRequest----------------");
            long currentTime = System.currentTimeMillis();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date(currentTime);
            log.error("currentTime：{}", formatter.format(date));
            log.error("responseTime:{}", (System.currentTimeMillis() - currentTime) + "ms");
            String requestUrl = request.getRequestURI();
            log.error("requestUrl： {} ", requestUrl);
            log.error("msg： {} ", expInfo);
            log.error("-------------------------End-------------------------");
            LogEntity log = new LogEntity();
            log.setCurrentTime(formatter.format(date))
                    .setResponseTime((System.currentTimeMillis() - currentTime) + "ms")
                    .setUrl(requestUrl).setParameter(sb.toString()).setMsg(expInfo);
            // 异常信息入表
            int id = logService.saveLog(log);
            return ResultUtil.error(ResultEnum.SYS_ERROR.getMsg() + " ，异常代码为：" + id);
        }
    }

    /**
     * 获取异常信息
     * @param ex ex
     * @return java.lang.String
     * @author mayuanbao
     * @date 2021/07/20 10:46
     */
    public static String getExceptionInfo(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        ex.printStackTrace(ps);
        String res = out.toString();
        ps.close();
        try {
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
