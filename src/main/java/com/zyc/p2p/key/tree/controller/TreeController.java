package com.zyc.p2p.key.tree.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.key.tree.model.TreeDto;
import com.zyc.p2p.key.tree.model.TreeNode;
import com.zyc.p2p.key.tree.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/tree")
public class TreeController extends BaseAction{

    @Autowired
    private ITreeNodeService treeNodeService;

    TreeDto treeDto = new TreeDto();

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> TreeNodelist(@RequestParam String ralename){
        Map<String, Object> map = null;
        if("".equals(ralename)){
            map = this.toMessage("请阁下先登录再使用", 2, null);
        } else {
            ralename(ralename);
            try {
                List<TreeNode> treeNodes = this.treeNodeService.TreeNodelist(treeDto);
                for (TreeNode t : treeNodes) {
                    setTreeNode(t.getTreeNodeId(),t);
                }
                map = this.toMessage("查询成功", 1, treeNodes);
            } catch (Exception e) {
                map = this.toMessage("查询失败", 0, null);
            }
        }
        return map;
    }

    public void setTreeNode(Integer treeNodeId,TreeNode t) throws Exception{
        List<TreeNode> treeNodes = this.treeNodeService.setTreeNode(treeNodeId);
        t.setChildren(treeNodes);
    }

    public void ralename(String ralename){
        if ("审核员".equals(ralename)){
            treeDto.setTree_node_id(new Integer[]{2,3});
        } else if ("财务".equals(ralename)){
            treeDto.setTree_node_id(new Integer[]{1,4,7});
        } else if ("催收人员".equals(ralename)){
            treeDto.setTree_node_id(new Integer[]{5});
        }else if("超级管理员".equals(ralename)){
            treeDto.setTree_node_id(new Integer[]{1,2,3,4,5,6,7});
        }else {
            treeDto.setTree_node_id(new Integer[]{8});
        }
    }

}
