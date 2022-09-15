package com.chenum.util;

import lombok.extern.slf4j.Slf4j;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
public class BeanUtils {

    public static void copyProperties(Object source, Object target, String... ignoreField) {
        assert source != null && target != null;
        Map<String, Object> map = entityToMap(source);
        Class<?> targetSource = target.getClass();
        List<String> ignoreFields = Arrays.stream(ignoreField).toList();
        for (String s : map.keySet()) {
            try {
                if (ignoreFields.contains(s) || s.equals("class")){
                    continue;
                }
                Object value = map.get(s);
                Method getMethod = targetSource.getMethod(FieldUtils.getter(s));
                Class<?> FieldType = getMethod.getReturnType();
                Method method = targetSource.getMethod(FieldUtils.setter(s), FieldType);
                if (value instanceof List<?>) {
                    value = JsonUtil.toJsonString(value);
                }
                method.invoke(target, value);
            } catch (IllegalArgumentException iae){

            }catch (NoSuchMethodException nsme) {

            }catch (IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }
    }

    public static void copyProperties(Object source, Object target, boolean supper,String... ignoreField) {
        assert source != null && target != null;
        Map<String, Object> map = entityToMap(source,supper);
        Class<?> targetSource = target.getClass();
        List<String> ignoreFields = Arrays.stream(ignoreField).toList();
        for (String s : map.keySet()) {
            try {
                if (ignoreFields.contains(s) || s.equals("class")){
                    continue;
                }
                Object value = map.get(s);
                Method getMethod = targetSource.getMethod(FieldUtils.getter(s));
                Class<?> FieldType = getMethod.getReturnType();
                Method method = targetSource.getMethod(FieldUtils.setter(s), FieldType);
                if (value instanceof List<?>) {
                    value = JsonUtil.toJsonString(value);
                }
                method.invoke(target, value);
            }catch (IllegalArgumentException iae){

            }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException nsme) {
                nsme.printStackTrace();
            }
        }
    }


    public static Map<String, Object> entityToMap(Object entity,boolean supper) {
        try {
            PropertyDescriptor[] propertyDescriptor = getPropertyDescriptors(entity,supper);
            Map<String,Object> map = new HashMap<>();
            for (PropertyDescriptor descriptor : propertyDescriptor) {
                Method method = descriptor.getReadMethod();
                Object value = method.invoke(entity);
                map.put(descriptor.getName(),value);
            }
            return map;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取实体以及父类的属性
     * @param entity
     * @return
     */
    public static Map<String, Object> entityToMap(Object entity) {
        return entityToMap(entity,true);
    }

    private static PropertyDescriptor[] getPropertyDescriptors(Object obj,boolean supper){
        try {
            BeanInfo beanInfo;
            Class<?> clazz = obj.getClass();
            if (!supper){
                beanInfo = Introspector.getBeanInfo(clazz,clazz.getSuperclass());
            }else{
                beanInfo = Introspector.getBeanInfo(clazz);
            }
            return beanInfo.getPropertyDescriptors();
        }catch (IntrospectionException ie){
            throw new RuntimeException(ie);
        }
    }
}
