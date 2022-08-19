package com.chenum.mybatis;

import com.chenum.util.JsonUtil;
import com.chenum.vo.ArticleVO;
import com.chenum.vo.CommentVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.internal.Bytes;
import org.junit.Test;

import javax.annotation.Resource;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
public class TestSample {

    @Test
    public void objectMapper() throws JsonProcessingException {
        System.out.println(JsonUtil.toJsonString(new CommentVO()));
    }

    @Test
    public void testObjects() throws NoSuchFieldException, IllegalAccessException {
        String str = "abc";
        Class clazz = str.getClass();
        Field field = clazz.getDeclaredField("value");
        System.out.println(clazz.getModule());
        field.setAccessible(true);
        field.get(str);
    }


    @Test
    public void json(){
        Class clazz = String.class;
        System.out.println(clazz == String.class);
    }
}
