package com.zyc.p2p.key.tree.mapper;

import com.zyc.p2p.key.tree.model.TreeDto;
import com.zyc.p2p.key.tree.model.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeNodeMapper {

    List<TreeNode> TreeNodelist(TreeDto treeDto) throws Exception;

    List<TreeNode>  setTreeNode(Integer treeNodeId) throws Exception;


}