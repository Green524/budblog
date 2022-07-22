package com.chenum.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJsonString(Object obj){
        try{
            return objectMapper.writeValueAsString(obj);
        }catch (JsonProcessingException jpe){
            throw new RuntimeException(jpe.getMessage());
        }
    }
}
