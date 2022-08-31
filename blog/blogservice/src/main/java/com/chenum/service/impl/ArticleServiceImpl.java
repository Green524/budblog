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
import com.chenum.vo.ArticleResponseVO;
import com.chenum.vo.ArticleVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.*;

import static com.chenum.constant.VField.*;

@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    @ParameterCheckAdvice(parameters = {"createTime","updateTime","title"})
    public Wrapper<ArticleResponseVO> add(ArticleVO articleVO) {
        Article article = new Article();
        BeanUtils.copyProperties(articleVO,article,SERIAL_VERSION_UID);
        article.setLastReviewer("[]");
        int updates = articleMapper.insert(article);
        if (updates == 0){
            throw new BusinessException(BaseEnum.INERT_ERROR);
        }
        Article record = articleMapper.selectByPrimaryKey(article.getId());
        return WrapMapper.ok(getArticleResponseVO(record));
    }

    @Override
    @ParameterCheckAdvice(parameters = {"id"})
    public Wrapper<Boolean> del(ArticleVO articleVO) {
        int deletes = articleMapper.deleteByPrimaryKey(articleVO.getId());
        if (deletes == 0){
            WrapMapper.ok(Boolean.FALSE);
        }
        return WrapMapper.ok(Boolean.TRUE);
    }

    @Override
    @Page
    public Wrapper<PageInfo<ArticleResponseVO>> selectByPage(ArticleVO articleVO) {
        Map<String,Object> params = BeanUtils.entityToMap(articleVO);
        List<Article> records = articleMapper.selectByPage(params);
        List<ArticleResponseVO> voList = new ArrayList<>(records.size());
        records.forEach((article -> voList.add(getArticleResponseVO(article))));
        return WrapMapper.ok(PageInfo.of(voList));
    }

    @Override
    @ParameterCheckAdvice(parameters = "id")
    public Wrapper<ArticleResponseVO> updateOne(ArticleVO articleVO) {
        String id = articleVO.getId();
        Article article = articleMapper.selectByPrimaryKey(id);
        if (Objects.isNull(article)){
            throw new BusinessException(BaseEnum.SELECT_ERROR);
        }
        BeanUtils.copyProperties(articleVO,article,"id");
        article.setUpdateTime(new Date());
        article.setLastReviewer(JsonUtil.toJsonString(List.of(articleVO.getCreator())));
        articleMapper.updateByPrimaryKeySelective(article);
        return WrapMapper.ok(getArticleResponseVO(articleMapper.selectByPrimaryKey(id)));
    }

    @Override
    public Wrapper<ArticleResponseVO> query(String id) {
        if (StringUtils.isEmpty(id)){
            throw new BusinessException(BaseEnum.PARAMS_ERROR.setData(id));
        }
        Article article = articleMapper.selectByPrimaryKey(id);
        return WrapMapper.ok(getArticleResponseVO(article));
    }


    private ArticleResponseVO getArticleResponseVO(Article article){
        ArticleResponseVO vo = new ArticleResponseVO();
        BeanUtils.copyProperties(article,vo,false);
        vo.setContentTag(article.getContentTag().split(","));
        vo.setContent(MarkdownUtil.md2Html(article.getContent()));
        vo.setAuthor(JsonUtil.jsonToObject(article.getAuthor(),List.class));
        return vo;
    }
}
