package com.chenum.interceptor;

import com.chenum.exception.BusinessException;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionInterceptor {

    static Logger log = LoggerFactory.getLogger(ExceptionInterceptor.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Wrapper<?> businessException(BusinessException be){
        log.error("发生业务异常：{}",be.getMessage());
        be.printStackTrace();
        return WrapMapper.error(be.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Wrapper<?> exception(Exception e){
        log.error("内部错误:{}",e.getMessage());
        e.printStackTrace();
        return WrapMapper.error(e.getMessage());
    }
}
