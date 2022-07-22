package com.chenum.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Slf4j
public class BeanUtils {

    public static void copyProperties(Object source,Object target,String...ignoreField){
        assert source != null && target != null;
        try {
            Map<String,Object> map = entityToMap(source);
            Class<?> targetSource = target.getClass();
            Field[] fields = targetSource.getDeclaredFields();
            List<String> ignore = Arrays.stream(ignoreField).toList();
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                if (ignore.contains(name)){
                    continue;
                }
                Object value = map.get(name);
                if (value instanceof List){
                    value = JsonUtil.toJsonString(value);
                }
                field.set(target,value);
            }
        }catch (IllegalAccessException iae){
            log.error("实体转换失败");
            iae.printStackTrace();
            throw new RuntimeException(iae.getMessage());
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
    public static Map<String,Object> entityToMap(Object entity) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> entityClass = entity.getClass();
        Field[] fields = entityClass.getDeclaredFields();
        Map<String,Object> map = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(entity);
            map.put(name,value);
        }
        return map;
    }
}
