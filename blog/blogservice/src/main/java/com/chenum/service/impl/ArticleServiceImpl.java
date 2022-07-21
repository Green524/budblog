package com.chenum.service.impl;

import com.chenum.advice.ParameterCheckAdvice;
import com.chenum.dao.ArticleMapper;
import com.chenum.enums.BaseEnum;
import com.chenum.exception.BusinessException;
import com.chenum.po.Article;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.service.IArticleService;
import com.chenum.vo.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    @ParameterCheckAdvice(parameters = {"createTime","updateTime","title"})
    public Wrapper<Article> add(ArticleVO articleVO) {
        System.out.println(articleVO);
        if (ObjectUtils.isEmpty(articleVO)){
            throw new BusinessException(BaseEnum.ERROR);
        }
        Article article = new Article();
        BeanUtils.copyProperties(articleVO,article);
        article.setLastReviewer("[]");
        article.setContribution("[]");
        int updates = articleMapper.insert(article);
        if (updates == 0){
            throw new BusinessException(BaseEnum.INERT_ERROR);
        }
        Article record = articleMapper.selectByPrimaryKey(article.getId());
        return WrapMapper.ok(record);
    }

    @Override
    public Wrapper<Boolean> del(ArticleVO articleVO) {

//        if ()
        return null;
    }
}
