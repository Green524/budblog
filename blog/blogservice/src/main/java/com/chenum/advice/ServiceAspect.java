package com.chenum.advice;

import com.chenum.enums.BaseEnum;
import com.chenum.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Component
@Aspect
public class ServiceAspect{

    @Before("@annotation(com.chenum.advice.ParameterCheckAdvice)")
    @Order(Integer.MIN_VALUE)
    public void before(JoinPoint jp) throws NoSuchFieldException, IllegalAccessException {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        ParameterCheckAdvice parameterCheckAdvice = methodSignature.getMethod().getAnnotation(ParameterCheckAdvice.class);
        //需要检查的field
        String[] parameters = parameterCheckAdvice.parameters();
        int order = parameterCheckAdvice.order();
        Object[] args = jp.getArgs();
        Object arg = args[order];
        Class<?> argClass = arg.getClass();
        for (String parameter : parameters) {
            Field field = argClass.getDeclaredField(parameter);
            field.setAccessible(true);
            Object value = field.get(arg);
            if (StringUtils.equals(parameter,"createTime") || StringUtils.equals(parameter,"updateTime")){
                value = new Date();
                field.set(arg,value);
            }
            if (value instanceof String valueOfStr){
                if (StringUtils.isEmpty(valueOfStr)){
                    log.error("parameter {} is {}",parameter,value);
                    throw new BusinessException(BaseEnum.PARAMS_ERROR).setData(valueOfStr);
                }
            }else if (value instanceof Date valueOfDate){
                if (Objects.isNull(valueOfDate)){
                    log.error("parameter {} is {}",parameter,value);
                    throw new BusinessException(BaseEnum.PARAMS_ERROR).setData(valueOfDate);
                }
            }else{
                if (Objects.isNull(value)){
                    log.error("parameter {} is {}",parameter, null);
                    throw new BusinessException(BaseEnum.PARAMS_ERROR);
                }
            }
        }
        System.out.println(arg);
    }
}
