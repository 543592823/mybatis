package com.zyc.p2p.key.charge.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.audit.model.AuditTask;
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

}
