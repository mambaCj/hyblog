package com.mamba.web.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * base controller
 */
public abstract class BaseController {
    @Autowired
    private MessageSource messageSource;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected <T> Result<T> success(T data) {
        String message = messageSource.getMessage(Constants.CODE_SUCCESS, null, "成功", null);
        return new Result<T>(Constants.CODE_SUCCESS, message, data);
    }

    protected <T> Result<T> success() {
        String message = messageSource.getMessage(Constants.CODE_SUCCESS, null, "成功", null);
        return new Result<T>(Constants.CODE_SUCCESS, message, null);
    }

    protected <T> Result<T> success(String code, Object[] param, T data) {
        String message = messageSource.getMessage(code, param, "成功", null);
        return new Result<T>(code, message, data);
    }

    protected <T> Result<T> fail(String code) {
        String message = messageSource.getMessage(code, null, code, null);
        return new Result<T>(code, message);
    }

    protected <T> Result<T> failWithMessage(String code,String message){
        return new Result<T>(code,message);
    }

    protected <T> Result<T> fail(String code, Object[] params) {
        String message = messageSource.getMessage(code, params, "系统错误", null);
        return new Result<T>(code, message);
    }

    protected <T> Result<T> fail(String code, String desc) {
        String message = messageSource.getMessage(code, null, desc, null);
        return new Result<T>(code, message);
    }

    protected <T> Result<T> fail(String code, Object[] params, T data) {
        String message = messageSource.getMessage(code, params, null, null);
        return new Result<T>(code, message, data);
    }
}
