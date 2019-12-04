package com.zyc.p2p.key.audit.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.audit.model.AuditTask;
import com.zyc.p2p.key.audit.service.IAuditTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/audit")
public class AuditTaskController extends BaseAction{

    @Autowired
    private IAuditTaskService auditTaskService;

    //审核任务
    @RequestMapping("/tack")
    @ResponseBody
    public Map<String, Object> tackList(AuditTask auditTask, HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<AuditTask> list = this.auditTaskService.tackListPager(auditTask,pageBean);
            map = this.toPage("查询成功", 1, list,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        return map;
    }

    //我的审核任务
    @RequestMapping("/myTack")
    @ResponseBody
    public Map<String, Object> myTackList(AuditTask auditTask, HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<AuditTask> list = this.auditTaskService.myTackListPager(auditTask,pageBean);
            map = this.toPage("查询成功", 1, list,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        return map;
    }

    //放款复核
    @RequestMapping("/put")
    @ResponseBody
    public Map<String, Object> putTackList(AuditTask auditTask, HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<AuditTask> list = this.auditTaskService.putTackListPager(auditTask,pageBean);
            map = this.toPage("查询成功", 1, list,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        return map;
    }

}
