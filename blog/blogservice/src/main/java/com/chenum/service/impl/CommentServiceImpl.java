package com.chenum.service.impl;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.chenum.advice.Page;
import com.chenum.advice.ParameterCheckAdvice;
import com.chenum.dao.ArticleMapper;
import com.chenum.dao.CommentMapper;
import com.chenum.enums.BaseEnum;
import com.chenum.exception.BusinessException;
import com.chenum.po.Article;
import com.chenum.po.Comment;
import com.chenum.po.TreeNode;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.service.ICommentService;
import com.chenum.util.BeanUtils;
import com.chenum.util.TreeNodeUtil;
import com.chenum.vo.ArticleVO;
import com.chenum.vo.CommentTreeNodeVO;
import com.chenum.vo.CommentVO;
import com.github.pagehelper.PageInfo;
import com.sun.source.doctree.CommentTree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private ArticleMapper articleMapper;

    @Override
    @ParameterCheckAdvice(parameters = {"comment", "createTime", "updateTime"})
    public Wrapper<Comment> insert(CommentVO commentVO) {
        String articleId = commentVO.getArticleId();
        if (StringUtils.isNotEmpty(articleId)) {
            Article article = articleMapper.selectByPrimaryKey(articleId);
            if (Objects.isNull(article)) {
                throw new BusinessException(BaseEnum.INERT_ERROR.setData(articleId));
            }
        }
        String parentId = commentVO.getParentId();
        if (StringUtils.isNotEmpty(parentId)) {
            Comment parentComment = commentMapper.selectByPrimaryKey(parentId);
            if (Objects.isNull(parentComment)) {
                throw new BusinessException(BaseEnum.INERT_ERROR.setData(parentId));
            }
        }

        Comment comment = new Comment();
        BeanUtils.copyProperties(commentVO, comment);
        long inserts = commentMapper.insertSelective(comment);
        return WrapMapper.ok(commentMapper.selectByPrimaryKey(comment.getId()));
    }

    @Override
    @ParameterCheckAdvice(parameters = "id")
    public Wrapper<Boolean> delete(String id) {
        long deletes = commentMapper.deleteByPrimaryKey(id);
        if (deletes == 0) {
            return WrapMapper.error(Boolean.FALSE);
        }
        return WrapMapper.ok(Boolean.TRUE);
    }

    @Override
    @Page
    @ParameterCheckAdvice(parameters = "articleId")
    public Wrapper<PageInfo<Comment>> selectByArticleId(CommentVO commentVO) {
        Comment comment = new Comment();
        comment.setArticleId(commentVO.getArticleId());
        List<Comment> record = commentMapper.selectSelective(comment);
        List<Object> commentTreeNodeVOS = BeanUtils.copyListProperties(record,CommentTreeNodeVO.class);

        List<List<TreeNode>> treeNodeList = new ArrayList<>();
        for (Object commentTreeNodeVO : commentTreeNodeVOS) {
            CommentTreeNodeVO vo = (CommentTreeNodeVO) commentTreeNodeVO;
            treeNodeList.add(TreeNodeUtil.build(commentTreeNodeVOS,vo.getId()));
        }
        System.out.println(treeNodeList);
        return WrapMapper.ok(PageInfo.of(record));
    }
}
