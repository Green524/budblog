package com.chenum.mybatis;

import com.chenum.vo.ArticleVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSample {

    @Resource
    private ObjectMapper objectMapper;

    @Test
    public void objectMapper() throws JsonProcessingException {
        objectMapper.setSerializationInclusion(JsonInclude.Include.USE_DEFAULTS);
        String json = objectMapper.writeValueAsString(new ArticleVO());
        System.out.println(json);
    }
}
