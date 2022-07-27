package com.chenum.mybatis;

import com.chenum.constant.VField;
import com.chenum.util.JsonUtil;
import com.chenum.vo.ArticleVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class TestSample {

    @Resource
    private ObjectMapper objectMapper;

    @Test
    public void objectMapper() throws JsonProcessingException {
        objectMapper.setSerializationInclusion(JsonInclude.Include.USE_DEFAULTS);
        String json = objectMapper.writeValueAsString(new ArticleVO());
        System.out.println(json);
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

    public static void main(String[] args) throws NoSuchFieldException {
        String str = "abc";
        Class clazz = str.getClass();
        Field field = clazz.getDeclaredField("value");
        System.out.println(clazz.getModule());
        System.out.println(TestSample.class.getModule());
        field.setAccessible(true);
    }





    @Test
    public void json(){
        System.out.println(JsonUtil.jsonToObject("abc", Map.class));
    }
}
