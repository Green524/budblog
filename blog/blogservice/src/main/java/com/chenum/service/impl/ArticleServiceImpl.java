package com.chenum.service.impl;

import com.chenum.advice.Page;
import com.chenum.advice.ParameterCheckAdvice;
import com.chenum.dao.ArticleMapper;
import com.chenum.enums.BaseEnum;
import com.chenum.exception.BusinessException;
import com.chenum.po.Article;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.service.IArticleService;
import com.chenum.util.BeanUtils;
import com.chenum.vo.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static com.chenum.constant.VField.*;

@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {


    @Resource
    private ArticleMapper articleMapper;

    @Override
    @ParameterCheckAdvice(parameters = {"createTime","updateTime","title"})
    public Wrapper<Article> add(ArticleVO articleVO) {
        System.out.println(articleVO);
        Article article = new Article();
        BeanUtils.copyProperties(articleVO,article,SERIAL_VERSION_UID);
        article.setLastReviewer("[]");
        System.out.println(article);
        int updates = articleMapper.insert(article);
        if (updates == 0){
            throw new BusinessException(BaseEnum.INERT_ERROR);
        }
        Article record = articleMapper.selectByPrimaryKey(article.getId());
        return WrapMapper.ok(record);
    }

    @Override
    @ParameterCheckAdvice(parameters = {"id"})
    public Wrapper<Boolean> del(ArticleVO articleVO) {
        int deletes = articleMapper.deleteByPrimaryKey(articleVO.getId());
        if (deletes == 0){
            throw new BusinessException(BaseEnum.DELETE_ERROR);
        }
        return WrapMapper.ok(Boolean.TRUE);
    }

    @Override
    @Page
    public Wrapper<List<Article>> selectByPage(ArticleVO articleVO) {
        Map<String,Object> params = BeanUtils.entityToMap(articleVO);
        List<Article> list = articleMapper.selectByPage(params);
        return WrapMapper.ok(list);
    }

    @Override
    public Wrapper<Article> updateOne(ArticleVO articleVO) {
        return null;
    }
}
