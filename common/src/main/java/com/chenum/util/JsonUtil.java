package com.chenum.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException jpe) {
            throw new RuntimeException(jpe.getMessage());
        }
    }

    public static <T> T jsonToObject(String json,Class<T> clazz){
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException jpe) {
            throw new RuntimeException(jpe.getMessage());
        }

    }
}
