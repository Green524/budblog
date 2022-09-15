package com.chenum.controller;

import com.chenum.annotation.ApiPass;
import com.chenum.po.Comment;
import com.chenum.response.Wrapper;
import com.chenum.service.ICommentService;
import com.chenum.vo.CommentResponseVO;
import com.chenum.vo.CommentVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Resource
    private ICommentService iCommentService;

    @PostMapping("/add")
    public Wrapper<Comment> add(@RequestBody CommentVO commentVO){
        return iCommentService.insert(commentVO);
    }

    @DeleteMapping("/delete/{id}")
    public Wrapper<Boolean> delete(@PathVariable String id){
        return iCommentService.delete(id);
    }

    /**
     * 两级数评论
     * @param commentVO
     * @return
     */
    @GetMapping("/get/byarticleid")
    @ApiPass
    public Wrapper<PageInfo<CommentResponseVO>> selectByArticleId(CommentVO commentVO){
        return iCommentService.selectByArticleId(commentVO);
    }

    @PutMapping("/modify")
    public Wrapper<Comment> modify(@RequestBody CommentVO commentVO){
        return iCommentService.update(commentVO);
    }
}
