package com.chenum.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {

    private static List<? extends Node> nodes;
    
    public List<Node> buildTreeList(List<? extends Node> records){
        nodes = records;
        List<Node> rootNodes = getRootNodes();
        for (Node rootNode : rootNodes) {
            rootNode.setChildren(getChildren(rootNode));
        }
        return rootNodes;
    }
    public List<Node> getChildren(Node root){
        List<Node> childrenNodes = new ArrayList<>();
        for (Node n : nodes) {
            if (root.getId().equals(n.getPid())){
                n.setChildren(getChildren(n));
                childrenNodes.add(n);
            }
        }
        return childrenNodes;
    }



    public List<Node> getRootNodes(){
        List<Node> rootNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (isRootNode(node)){
                rootNodes.add(node);
            }
        }
        return rootNodes;
    }

    private boolean isRootNode(Node t){
        for (Node n : nodes) {
            if (n.getId().equals(t.getPid())){
                return false;
            }
        }
        return true;
    }
}
