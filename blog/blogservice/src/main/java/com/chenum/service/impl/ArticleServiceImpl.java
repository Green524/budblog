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
import com.chenum.util.JsonUtil;
import com.chenum.util.MarkdownUtil;
import com.chenum.vo.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.chenum.constant.VField.*;

@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {


    @Resource
    private ArticleMapper articleMapper;

    @Override
    @ParameterCheckAdvice(parameters = {"createTime","updateTime","title"})
    public Wrapper<Article> add(ArticleVO articleVO) {
        Article article = new Article();
        BeanUtils.copyProperties(articleVO,article,SERIAL_VERSION_UID);
        article.setLastReviewer("[]");
        int updates = articleMapper.insert(article);
        if (updates == 0){
            throw new BusinessException(BaseEnum.INERT_ERROR);
        }
        Article record = articleMapper.selectByPrimaryKey(article.getId());
        content(record);
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
        list.forEach(this::content);
        return WrapMapper.ok(list);
    }

    @Override
    @ParameterCheckAdvice(parameters = "id")
    public Wrapper<Article> updateOne(ArticleVO articleVO) {
        String id = articleVO.getId();
        Article article = articleMapper.selectByPrimaryKey(id);
        if (Objects.isNull(article)){
            throw new BusinessException(BaseEnum.SELECT_ERROR);
        }
        BeanUtils.copyProperties(articleVO,article,"id");
        article.setUpdateTime(new Date());
        article.setLastReviewer(JsonUtil.toJsonString(List.of(articleVO.getCreator())));
        long updates = articleMapper.updateByPrimaryKeySelective(article);

        return WrapMapper.ok(articleMapper.selectByPrimaryKey(id));
    }

    @Override
    public Wrapper<Article> query(String id) {
        if (StringUtils.isEmpty(id)){
            throw new BusinessException(BaseEnum.PARAMS_ERROR).setData(id);
        }
        Article article = articleMapper.selectByPrimaryKey(id);
        content(article);
        return WrapMapper.ok(article);
    }


    private void content(Article article){
        article.setContent(MarkdownUtil.md2Html(article.getContent()));
    }
}
