package com.chenum.util;

import com.chenum.po.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtil {

    public static List<TreeNode> build(List<?> list, String pid){
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (Object obj : list) {
            TreeNode treeNode = (TreeNode) obj;
            if (treeNode.getParentId().equals(pid)){
                treeNode.setChildren(build(list, treeNode.getId()));

            }
            treeNodeList.add(treeNode);
        }
        return treeNodeList;
    }
}
