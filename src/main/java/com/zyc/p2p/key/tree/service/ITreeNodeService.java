package com.zyc.p2p.key.tree.service;

import com.zyc.p2p.key.tree.model.TreeDto;
import com.zyc.p2p.key.tree.model.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ITreeNodeService {


    List<TreeNode> TreeNodelist(TreeDto treeDto) throws Exception;

    List<TreeNode>  setTreeNode(Integer treeNodeId) throws Exception;

}