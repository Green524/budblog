package com.chenum.util;

import com.chenum.response.Wrapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    static{
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static String toJsonString(Object obj,boolean nonNull) {
        try {
            if (nonNull){
                objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
            }
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException jpe) {
            throw new RuntimeException(jpe.getMessage());
        }
    }
    public static String toJsonString(Object obj) {
        return toJsonString(obj,false);
    }

    public static <T> T jsonToObject(String json,Class<T> clazz){
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException jpe) {
            throw new RuntimeException(jpe.getMessage());
        }

    }

    public static <T> T jsonToObject(String json,TypeReference<T> typeReference){
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (JsonProcessingException jpe) {
            throw new RuntimeException(jpe.getMessage());
        }
    }
}
