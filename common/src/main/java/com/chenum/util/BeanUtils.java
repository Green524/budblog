package com.chenum.util;

import lombok.extern.slf4j.Slf4j;

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
                if (ignoreFields.contains(s) ){
                    continue;
                }
                Object value = map.get(s);
                Method getMethod = targetSource.getMethod(FieldUtils.getter(s));
                Class<?> FieldType = getMethod.getReturnType();
                Method method = targetSource.getDeclaredMethod(FieldUtils.setter(s), FieldType);
                if (value instanceof List<?>) {
                    value = JsonUtil.toJsonString(value);
                }
                method.invoke(target, value);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException nsme) {

            }
        }
    }

    public static List<Object> copyListProperties(List<?> source, Class<?> targetClass){
        List<Object> result = new ArrayList<>(source.size());;
        try {
            for (Object o : source) {
                Constructor<?> constructor = targetClass.getConstructor();
                Object obj = constructor.newInstance();
                BeanUtils.copyProperties(o,obj);
                result.add(obj);
            }
        }catch (Exception e){
            log.error("复制属性失败,{}",e.getMessage());
        }
        return result;
    }

    public static Map<String, Object> entityToMap(Object entity) {
        Class<?> entityClass = entity.getClass();
        Method[] methods = entityClass.getMethods();
        Map<String, Object> map = new HashMap<>();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                try {
                    Object value = method.invoke(entity);
                    if (Objects.isNull(value)){
                        continue;
                    }
                    map.put(FieldUtils.field(methodName), value);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }

        }
        return map;
    }
}
