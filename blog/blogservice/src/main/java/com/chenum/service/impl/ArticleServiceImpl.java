package com.chenum.service.impl;

import com.chenum.dao.ArticleMapper;
import com.chenum.enums.BaseEnum;
import com.chenum.exception.BusinessException;
import com.chenum.po.Article;
import com.chenum.service.IArticleService;
import com.chenum.vo.ArticleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Article add(ArticleVO articleVO) {
        if (Objects.isNull(articleVO)){
            throw new BusinessException(BaseEnum.ERROR);
        }
        return new Article();
    }
}
