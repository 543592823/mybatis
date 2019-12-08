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

    //逾期详情
    @RequestMapping("/overdueDetails")
    @ResponseBody
    public Map<String, Object> overdueDetails(ChargeRecord record, HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);

        try {
            Long over =MyDateUtil.between_days(record.getChargeDate(),record.getRefundDate());
            record.setOverdueCount(over);
            AuditTask auditTask=new AuditTask();
            if(auditTask.getLoanManay()>1000&&auditTask.getLoanManay()<=2000){
                record.setOverdueCost(record.getOverdueCount()*6);
            }
            if (auditTask.getLoanManay()>2000&&auditTask.getLoanManay()<=3000){
                record.setOverdueCost(record.getOverdueCount()*8);
            }
            if (auditTask.getLoanManay()>3000&&auditTask.getLoanManay()<=5000){
                record.setOverdueCost(record.getOverdueCount()*12);
            }
            if (auditTask.getLoanManay()>5000&&auditTask.getLoanManay()<=10000){
                record.setOverdueCost(record.getOverdueCount()*16);
            }
            System.err.println("record=="+record);
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
