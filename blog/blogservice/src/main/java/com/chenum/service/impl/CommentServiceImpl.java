package com.chenum.service.impl;

import com.chenum.advice.Page;
import com.chenum.advice.ParameterCheckAdvice;
import com.chenum.dao.ArticleMapper;
import com.chenum.dao.CommentMapper;
import com.chenum.enums.BaseEnum;
import com.chenum.exception.BusinessException;
import com.chenum.po.Article;
import com.chenum.po.Comment;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.service.ICommentService;
import com.chenum.tree.Node;
import com.chenum.tree.TreeBuilder;
import com.chenum.vo.CommentResponseVO;
import com.chenum.vo.CommentTreeNode;
import com.chenum.vo.CommentVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
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
//            if (Objects.isNull(article)) {
//                throw new BusinessException(BaseEnum.INERT_ERROR.setData(articleId));
//            }
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
        commentMapper.insertSelective(comment);
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
            CommentTreeNode node = new CommentTreeNode();
            BeanUtils.copyProperties(record,node);
            commentTreeNodeVOS.add(node);
        }
        List<Node> list = new TreeBuilder().buildTreeList(commentTreeNodeVOS);
        return WrapMapper.ok(PageInfo.of(list));
    }

    @Override
    @Page
    @ParameterCheckAdvice(parameters = "articleId")
    public Wrapper<PageInfo<CommentResponseVO>> selectByArticleId1(CommentVO commentVO) {
        Comment comment = new Comment();
        comment.setArticleId(commentVO.getArticleId());
        comment.setParentId("0");
        List<Comment> parentRecords = commentMapper.selectSelective(comment);
        List<CommentResponseVO> commentResponseVOS = new ArrayList<>();
        for (Comment parentRecord : parentRecords) {
            subCommentResponseVOS.clear();
            CommentResponseVO commentResponseVO = new CommentResponseVO();
            commentResponseVO.setId(parentRecord.getId());
            commentResponseVO.setCommentUser(new CommentResponseVO.User(parentRecord.getId(), parentRecord.getCommenter(), ""));
            commentResponseVO.setContent(parentRecord.getComment());
            commentResponseVO.setCreateDate(parentRecord.getCreateTime());

            commentResponseVO.setChildrenList(sub(parentRecord));
            commentResponseVOS.add(commentResponseVO);
        }

        return WrapMapper.ok(PageInfo.of(commentResponseVOS));
    }

    List<CommentResponseVO> subCommentResponseVOS = new ArrayList<>();
    private List<CommentResponseVO> sub(Comment parentRecord){
        Comment comment = new Comment();
        comment.setArticleId(parentRecord.getArticleId());
        comment.setParentId(parentRecord.getId());

        List<Comment> subCommentList = commentMapper.selectSelective(comment);
        for (Comment subComment : subCommentList) {
            CommentResponseVO subCommentResponseVO = new CommentResponseVO();
            subCommentResponseVO.setId(subComment.getId());
            subCommentResponseVO.setCommentUser(new CommentResponseVO.User(subComment.getId(), subComment.getCommenter(), ""));
            subCommentResponseVO.setContent(subComment.getComment());
            subCommentResponseVO.setCreateDate(subComment.getCreateTime());
            subCommentResponseVO.setTargetUser(new CommentResponseVO.User(parentRecord.getId(),parentRecord.getCommenter(),""));

            sub(subComment);
            subCommentResponseVOS.add(subCommentResponseVO);
        }
        return subCommentResponseVOS;
    }

    @Override
    @ParameterCheckAdvice(parameters = "id")
    public Wrapper<Comment> update(CommentVO commentVO) {
        Comment comment = commentMapper.selectByPrimaryKey(commentVO.getId());
        if (Objects.isNull(comment)){
            log.error("修改评论失败，没有查询到评论");
            throw new BusinessException(BaseEnum.UPDATE_ERROR);
        }
        BeanUtils.copyProperties(commentVO,comment);
        comment.setUpdateTime(new Date());
        commentMapper.updateByPrimaryKeySelective(comment);
        return WrapMapper.ok(commentMapper.selectByPrimaryKey(commentVO.getId()));
    }
}
