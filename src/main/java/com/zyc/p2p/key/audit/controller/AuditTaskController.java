package com.zyc.p2p.key.audit.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.audit.model.AuditTask;
import com.zyc.p2p.key.audit.service.IAuditTaskService;
import com.zyc.p2p.key.charge.model.ChargeRecord;
import com.zyc.p2p.key.charge.service.IChargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/audit")
public class AuditTaskController extends BaseAction{

    @Autowired
    private IAuditTaskService auditTaskService;

    @Autowired
    private IChargeRecordService chargeRecordService;

    //审核任务
    @RequestMapping("/task")
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
    @RequestMapping("/myTask")
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
        if("请选择".equals(auditTask.getState())){
            auditTask.setState("");
        }
        System.err.println("auditTask=="+auditTask);
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<AuditTask> list = this.auditTaskService.putTackListPager(auditTask,pageBean);
            map = this.toPage("查询成功", 1, list,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        System.err.println("map=="+map);
        return map;
    }

    //放款复核
    @RequestMapping("/uptPut")
    @ResponseBody
    public Map<String, Object> uptPut(AuditTask auditTask){
        System.err.println("auditTask=="+auditTask);
        Map<String, Object> map = null;
        long date =new Date().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dateFormat.format(date);
        Integer year = Integer.parseInt(str.substring(0, 4).toString());
        Integer month =Integer.parseInt(str.substring(5, 7).toString());
        auditTask.setRefundTime(str);
        auditTask.setState("待还款");
        float cost = 0;//服务费
        float Interest = 0;//服务费
        if(auditTask.getPerlods() != 1) {
            cost = 30;//服务费
            Interest = auditTask.getLoanManay()*0.0005f*30;
        }
        try {
            this.auditTaskService.uptPut(auditTask);
                for (int i = 1;i<=auditTask.getPerlods();i++){
                    if(month < 12){
                        month+=1;
                    } else {
                        month=1;
                        year+=1;
                    }
                    String day = year+"-"+month+"-"+"06 00:00:00";
                    System.err.println("day=="+day);
                    ChargeRecord c = new ChargeRecord();
                    c.setRealName(auditTask.getRealName());//姓名
                    c.setIdNumber(auditTask.getIdNumber());//身份证号
                    c.setPerlods(i);//期数
                    c.setCapital(auditTask.getLoanManay()/auditTask.getPerlods());//本金
                    c.setInterest(Interest);//利息
                    c.setServiceCost(cost);//服务费
                    c.setCurrentReturn(c.getCapital()+c.getInterest()+c.getServiceCost());//本期应还
                    c.setState("未还款");//状态
                    c.setChargeDate(day);//扣款时间
                    this.chargeRecordService.insert(c);
                }
            map = this.toMessage("放款成功", 1, null);
        } catch (Exception e) {
            map = this.toMessage("放款失败", 0, null);
        }
        System.err.println("map=="+map);
        return map;
    }

    //审核任务
    @RequestMapping("/uptTask")
    @ResponseBody
    public Map<String, Object> uptTackState(AuditTask auditTask){
        Map<String, Object> map = null;
        auditTask.setState("已审核");
        try {
            this.auditTaskService.uptTackState(auditTask);
            map = this.toMessage("审核成功", 1, null);
        } catch (Exception e) {
            map = this.toMessage("审核失败", 0, null);
        }
        System.err.println("map=="+map);
        return map;
    }

    //正常扣款
    @RequestMapping("/loanList")
    @ResponseBody
    public Map<String, Object> loanList(AuditTask auditTask, HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<AuditTask> list = this.auditTaskService.loanListPager(auditTask,pageBean);
            map = this.toPage("查询成功", 1, list,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        System.err.println("map=="+map);
        return map;
    }

    //逾期管理
    @RequestMapping("/overdueList")
    @ResponseBody
    public Map<String, Object> overdueList(AuditTask auditTask, HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<AuditTask> list = this.auditTaskService.overdueList(auditTask,pageBean);
            map = this.toPage("查询成功", 1, list,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        System.err.println("map=="+map);
        return map;
    }


}
