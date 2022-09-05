package com.chenum.service;

import com.chenum.po.Comment;
import com.chenum.response.Wrapper;
import com.chenum.tree.Node;
import com.chenum.vo.CommentResponseVO;
import com.chenum.vo.CommentVO;
import com.github.pagehelper.PageInfo;

public interface ICommentService {

    Wrapper<Comment> insert(CommentVO commentVO);

    Wrapper<Boolean> delete(String id);

    Wrapper<PageInfo<CommentResponseVO>> selectByArticleId(CommentVO commentVO);

    Wrapper<Comment> update(CommentVO commentVO);
}
