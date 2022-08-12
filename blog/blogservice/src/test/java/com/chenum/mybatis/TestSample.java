package com.chenum.mybatis;

import com.chenum.util.JsonUtil;
import com.chenum.vo.ArticleVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.annotation.Resource;

import java.lang.reflect.Field;
import java.util.Map;

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

    public static String main(String[] args) throws NoSuchFieldException {
        String str = args[0];
        switch (str){
            case "march", "april", "may":
                return "春天";
            case "june", "july", "august":
                return "夏天";
            case "september", "october", "november":
                return "秋天";
            case "december", "january", "february":
                return "冬天";
            default:
                return "month error";
        }
    }

    public static String switchJava13(String month) {
        switch (month){
            case "march", "april", "may":
                return "春天";
            case "june", "july", "august":
                return "夏天";
            case "september", "october", "november":
                return "秋天";
            case "december", "january", "february":
                return "冬天";
            default:
                return "month error";
        }
    }






    @Test
    public void json(){
        System.out.println(JsonUtil.jsonToObject("abc", Map.class));
    }
}
