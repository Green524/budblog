package com.chenum.service;

import com.chenum.po.Comment;
import com.chenum.response.Wrapper;
import com.chenum.vo.CommentVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICommentService {

    Wrapper<Comment> insert(CommentVO commentVO);

    Wrapper<Boolean> delete(String id);

    Wrapper<PageInfo<Comment>> selectByArticleId(CommentVO commentVO);
}