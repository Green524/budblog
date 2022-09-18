package com.chenum.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJsonString(Object obj,boolean nonNull) {
        try {
            if (nonNull){
                objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
            }
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
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
}
