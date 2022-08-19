package com.chenum.advice;

import com.chenum.constant.VField;
import com.chenum.enums.BaseEnum;
import com.chenum.exception.BusinessException;
import com.chenum.util.FieldUtils;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.jsoup.internal.StringUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Component
@Aspect
public class ServiceAspect {

    @Before("@annotation(com.chenum.advice.ParameterCheckAdvice)")
    @Order(Integer.MIN_VALUE)
    public void parameterCheckBefore(JoinPoint jp) throws NoSuchFieldException, IllegalAccessException {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        ParameterCheckAdvice parameterCheckAdvice = methodSignature.getMethod().getAnnotation(ParameterCheckAdvice.class);
        //需要检查的field
        String[] parameters = parameterCheckAdvice.parameters();
        int order = parameterCheckAdvice.order();
        Object[] args = jp.getArgs();
        Object arg = args[order];
        if (Objects.isNull(arg)) {
            log.error("parameter is null");
            throw new BusinessException(BaseEnum.PARAMS_ERROR);
        }
        Class<?> argClass = arg.getClass();
        if (argClass == String.class){
            return;
        }
        for (String parameter : parameters) {
            Field field = argClass.getDeclaredField(parameter);
            field.setAccessible(true);
            Object value = field.get(arg);
            if (StringUtils.equals(parameter, VField.CREATE_TIME) || StringUtils.equals(parameter, VField.UPDATE_TIME)) {
                value = new Date();
                field.set(arg, value);
            }
            if (value instanceof String valueOfStr) {
                if (StringUtils.isEmpty(valueOfStr)) {
                    log.error("parameter {} is {}", parameter, VField.NULL);
                    throw new BusinessException(BaseEnum.PARAMS_ERROR.setData(valueOfStr));
                }
            }else if(value.getClass().isArray()){
                if (Array.getLength(value) == 0){
                    log.error("parameter {} is {}", parameter, VField.NULL);
                    throw new BusinessException(BaseEnum.PARAMS_ERROR);
                }
            }
            else {
                if (Objects.isNull(value)) {
                    log.error("parameter {} is {}", parameter, VField.NULL);
                    throw new BusinessException(BaseEnum.PARAMS_ERROR);
                }
            }
        }
    }

    @Before("@annotation(com.chenum.advice.Page)")
    @Order(Integer.MIN_VALUE + 1)
    public void pageHelperBefore(JoinPoint jp) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Page page = methodSignature.getMethod().getAnnotation(Page.class);
        if (Objects.nonNull(page)) {
            int order = page.order();
            Object[] args = jp.getArgs();
            Object arg = args[order];
            if (Objects.isNull(arg)) {
                log.error("parameter is null");
                throw new BusinessException(BaseEnum.PARAMS_ERROR);
            }
            Class clazz = arg.getClass();
            Method getPageNum = clazz.getMethod(FieldUtils.getter(VField.PAGE_NUM));
            Method getPageSize = clazz.getMethod(FieldUtils.getter(VField.PAGE_SIZE));
            int pageNum = (int) getPageNum.invoke(arg);
            int pageSize = (int) getPageSize.invoke(arg);
            PageHelper.startPage(pageNum, pageSize);
        }
    }
}
