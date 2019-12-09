package com.zyc.p2p.key.charge.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.MyDateUtil;
import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.audit.model.AuditTask;
import com.zyc.p2p.key.audit.service.IAuditTaskService;
import com.zyc.p2p.key.charge.model.ChargeRecord;
import com.zyc.p2p.key.charge.service.IChargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/charge")
public class ChargeController extends BaseAction {

    @Autowired
    private IChargeRecordService chargeRecordService;

    //查询扣款记录
    @RequestMapping("/recordList")
    @ResponseBody
    public Map<String, Object> selCharge(ChargeRecord record, HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        System.err.println("record=="+record);
        try {
            List<ChargeRecord> list = this.chargeRecordService.selChargePager(record,pageBean);
            System.err.println("list=="+list);
            map = this.toPage("查询成功", 1, list,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        System.err.println("map=="+map);
        return map;
    }

    //计算逾期天数和逾期费
    @RequestMapping("/updateOverdue")
    @ResponseBody
    public Map<String, Object> updateOverdue(ChargeRecord record){
        Map<String, Object> map = null;
        Long over =MyDateUtil.between_days(record.getChargeDate(),record.getRefundDate());
        record.setOverdueCount(over);
        AuditTask auditTask=new AuditTask();
        if(auditTask.getLoanManay()>1000 && auditTask.getLoanManay()<=2000){
            record.setOverdueCost(record.getOverdueCount()*6L);
        }
        if (auditTask.getLoanManay()>2000 && auditTask.getLoanManay()<=3000){
            record.setOverdueCost(record.getOverdueCount()*8L);
        }
        if (auditTask.getLoanManay()>3000 && auditTask.getLoanManay()<=5000){
            record.setOverdueCost(record.getOverdueCount()*12L);
        }
        if (auditTask.getLoanManay()>5000 && auditTask.getLoanManay()<=10000){
          record.setOverdueCost(record.getOverdueCount()*16L);
        }
        try {
            this.chargeRecordService.updateOverdue(record);
            map = this.toMessage("修改成功", 1, null);
        } catch (Exception e) {
            map = this.toMessage("修改失败", 0, null);
        }
        System.err.println("map=="+map);
        return map;
    }

    //逾期详情
    @RequestMapping("/overdueDetails")
    @ResponseBody
    public Map<String, Object> overdueDetails(ChargeRecord record, HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<ChargeRecord> list = this.chargeRecordService.overdueDetails(record,pageBean);
            System.err.println("list=="+list);
            map = this.toPage("查询成功", 1, list,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        System.err.println("map=="+map);
        return map;
    }

}
