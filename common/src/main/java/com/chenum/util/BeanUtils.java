package com.chenum.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
public class BeanUtils {

    /**
     * 将相同field的属性copy到target,目前只对List进行处理（@Code JsonUtil.toJsonString(value)），
     * 如果是别的类型不兼容，可能会出现copy失败
     * @param source
     * @param target
     * @param ignoreField
     */
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

    /**
     * 实体属性转成Map
     * @param entity
     * @return
     */
    public static Map<String, Object> entityToMap(Object entity) {
        Class<?> entityClass = entity.getClass();
        Method[] methods = entityClass.getMethods();
        Map<String, Object> map = new HashMap<>();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                try {
                    Object value = method.invoke(entity);
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
