package com.chenum.controller;

import com.chenum.po.Comment;
import com.chenum.response.Wrapper;
import com.chenum.service.ICommentService;
import com.chenum.tree.Node;
import com.chenum.vo.CommentResponseVO;
import com.chenum.vo.CommentVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
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

    @GetMapping("/get/byarticleid")
    public Wrapper<PageInfo<Node>> selectByArticleId(CommentVO commentVO){
        return iCommentService.selectByArticleId(commentVO);
    }

    @GetMapping("/get/byarticleid1")
    public Wrapper<PageInfo<CommentResponseVO>> selectByArticleId1(CommentVO commentVO){
        return iCommentService.selectByArticleId1(commentVO);
    }

    @PutMapping("/modify")
    public Wrapper<Comment> modify(@RequestBody CommentVO commentVO){
        return iCommentService.update(commentVO);
    }
}
