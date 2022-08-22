package com.chenum.tree;

import java.util.List;

public interface Node<T> {
    String getId();

    String getPid();

    List<T> getChildren();

    void setChildren(List<T> children);
}
