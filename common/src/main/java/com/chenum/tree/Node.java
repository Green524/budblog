package com.chenum.tree;

import java.util.List;

public interface Node<T> {
    String id();

    String pid();

    List<T> getChildren();

    void setChildren(List<T> children);
}
