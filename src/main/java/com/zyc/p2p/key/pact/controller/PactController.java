package com.zyc.p2p.key.pact.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.pact.model.PactUserpact;
import com.zyc.p2p.key.pact.service.IPactUserpactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pact")
public class PactController extends BaseAction{

    @Autowired
    private IPactUserpactService pactUserpactService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> selPactList(PactUserpact pactUserpact, HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<PactUserpact> list = this.pactUserpactService.selPactListPager(pactUserpact,pageBean);
            map = this.toPage("合同查询成功", 1, list,pageBean);
        } catch (Exception e) {
            map = this.toMessage("合同查询失败", 0, null);
        }
        return map;
    }

    @RequestMapping(value = "/addPact")
    @ResponseBody
    public Map<String, Object> PfuserList(PactUserpact pactUserpact){
        System.err.println("pactUserpact=="+pactUserpact);
        Map<String, Object> map = null;
        try {
            this.pactUserpactService.insertPact(pactUserpact);
            map = this.toMessage("合同签订成功", 1, null);
        } catch (Exception e) {
            map = this.toMessage("合同签订失败", 0, null);
        }
        return map;
    }


}
