package com.chenum.service.impl;

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
import com.chenum.tree.Node;
import com.chenum.tree.TreeBuilder;
import com.chenum.util.TreeNodeUtil;
import com.chenum.vo.CommentTreeNodeVO;
import com.chenum.vo.CommentVO;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
        if (StringUtils.isNotEmpty(parentId) && !StringUtils.equals(parentId,"0")) {
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
    public Wrapper<PageInfo<Node>> selectByArticleId(CommentVO commentVO) {
        Comment comment = new Comment();
        comment.setArticleId(commentVO.getArticleId());
        List<Comment> records = commentMapper.selectSelective(comment);
        List<Node> commentTreeNodeVOS = new ArrayList<>();
        for (Comment record : records) {
            CommentTreeNodeVO node = new CommentTreeNodeVO();
            BeanUtils.copyProperties(record,node);
            commentTreeNodeVOS.add(node);
        }
        List<Node> list = new TreeBuilder().buildTreeList(commentTreeNodeVOS);
        return WrapMapper.ok(PageInfo.of(list));
    }
}
