package com.chenum;

import com.chenum.po.Article;
import com.chenum.po.Comment;
import com.chenum.util.BeanUtils;
import com.chenum.util.JsonUtil;
import com.chenum.vo.ArticleVO;
import com.chenum.vo.CommentTreeNode;
import com.chenum.vo.CommentVO;
import org.junit.Test;


import java.lang.reflect.Field;
import java.util.*;

public class TestSample {

    @Test
    public void objectMapper() {
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
    public void beanInfo()  {
        CommentTreeNode commentTreeNode = new CommentTreeNode();
        Comment comment = new Comment();
        comment.setId(1);
        comment.setParentId(2);

        BeanUtils.copyProperties(comment,commentTreeNode);

        System.out.println(commentTreeNode.getId());
        System.out.println(commentTreeNode.getParentId());
        System.out.println(commentTreeNode.pid());
    }

    public Article article(){
        Article article = new Article();
        return article;
    }

    public ArticleVO articleVO(){
        ArticleVO articleVO = new ArticleVO();
        articleVO.setContent("jjjj");
        articleVO.setUpdateTime(new Date());
        articleVO.setIsComment(true);
        articleVO.setAuthor(List.of("1","2"));
        return articleVO;
    }
}
