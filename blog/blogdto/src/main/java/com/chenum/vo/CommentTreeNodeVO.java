package com.chenum.vo;

import com.chenum.po.Comment;
import com.chenum.po.TreeNode;
import com.chenum.tree.Node;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentTreeNodeVO extends Comment implements Node<CommentTreeNodeVO> {

    private List<CommentTreeNodeVO> children = new ArrayList<>();

    @Override
    public String getPid() {
        return getParentId();
    }

    @Override
    public List getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }
}
