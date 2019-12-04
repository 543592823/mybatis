package com.zyc.p2p.key.tree.service.impl;

import com.zyc.p2p.key.tree.mapper.TreeNodeMapper;
import com.zyc.p2p.key.tree.model.TreeDto;
import com.zyc.p2p.key.tree.model.TreeNode;
import com.zyc.p2p.key.tree.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeNodeServiceImpl implements ITreeNodeService {

    @Autowired
    private TreeNodeMapper treeNodeMapper;

    @Override
    public List TreeNodelist(TreeDto treeDto) throws Exception{
        return treeNodeMapper.TreeNodelist(treeDto);
    }

    @Override
    public List<TreeNode> setTreeNode(Integer treeNodeId) throws Exception {
        return this.treeNodeMapper.setTreeNode(treeNodeId);
    }



}
