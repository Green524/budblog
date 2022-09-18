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

    /**
     * 给网页使用
     * @param commentVO
     * @return
     */
    @PostMapping("/add")
    @ApiPass
    public Wrapper<Comment> add(@RequestBody CommentVO commentVO){
        commentVO.setIsAuthor(false);
        return iCommentService.insert(commentVO);
    }

    /**
     * 给客户端后台管理使用
     * @param commentVO
     * @return
     */
    @PostMapping("/bs/add")
    public Wrapper<Comment> backstageAdd(@RequestBody CommentVO commentVO){
        commentVO.setIsAuthor(true);
        return iCommentService.insert(commentVO);
    }

    @DeleteMapping("/delete/{id}")
    public Wrapper<Boolean> delete(@PathVariable String id){
        return iCommentService.delete(id);
    }

    /**
     * 两级数评论(网页)
     * @param commentVO
     * @return
     */
    @GetMapping("/get/byarticleid")
    @ApiPass
    public Wrapper<PageInfo<CommentResponseVO>> selectByArticleId(CommentVO commentVO){
        commentVO.setIsAuthor(false);
        return iCommentService.selectByArticleId(commentVO);
    }
    /**
     * 两级数评论(后台)
     * @param commentVO
     * @return
     */
    @GetMapping("/bs/get/byarticleid")
    public Wrapper<PageInfo<CommentResponseVO>> backstageSelectByArticleId(CommentVO commentVO){
        commentVO.setIsAuthor(true);
        return iCommentService.selectByArticleId(commentVO);
    }

    @PutMapping("/modify")
    public Wrapper<Comment> modify(@RequestBody CommentVO commentVO){
        return iCommentService.update(commentVO);
    }
}
