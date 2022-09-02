package com.chenum.vo;

import com.chenum.po.Comment;
import com.chenum.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class CommentTreeNode extends Comment implements Node<CommentTreeNode> {


    private List<CommentTreeNode> children = new ArrayList<>();

    @Override
    public String id() {
        return String.valueOf(getId());
    }

    @Override
    public String pid() {
        return String.valueOf(getParentId());
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
