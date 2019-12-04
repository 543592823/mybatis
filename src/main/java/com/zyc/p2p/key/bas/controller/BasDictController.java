package com.zyc.p2p.key.bas.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.bas.model.BasDict;
import com.zyc.p2p.key.bas.service.IBasDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/bas")
public class BasDictController extends BaseAction{

    @Autowired
    private IBasDictService basDictService;

    @RequestMapping(value = "/doList")
    @ResponseBody
    public Map<String, Object> doList(){
        Map<String, Object> map = null;
        try {
            List<BasDict> basDicts = this.basDictService.doList();
            map = this.toMessage("查询成功", 1, basDicts);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        return map;
    }

    @RequestMapping(value = "/basList")
    @ResponseBody
    public Map<String, Object> basList(BasDict basDict,HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<BasDict> basDicts = this.basDictService.basDictListPager(basDict,pageBean);
            map = this.toPage("查询成功", 1, basDicts,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        System.out.println("map="+map);
        return map;
    }

    @RequestMapping(value = "/meger")
    @ResponseBody
    public Map<String, Object> meger(BasDict record){
        Map<String, Object> map = null;
        if(record.getDictId() == null){
            try {
                this.basDictService.insert(record);
                map = this.toMessage("增加成功", 1, null);
            } catch (Exception e) {
                map = this.toMessage("增加失败", 0, null);
            }
        }else {
            try {
                this.basDictService.uptBasDict(record);
                map = this.toMessage("修改成功", 1, null);
            } catch (Exception e) {
                map = this.toMessage("修改失败", 0, null);
            }
        }

        return map;
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public Map<String, Object> delBasDict(BasDict record){
        Map<String, Object> map = null;
        try {
            this.basDictService.delBasDict(record);
            map = this.toMessage("删除成功", 1, null);
        } catch (Exception e) {
            map = this.toMessage("删除失败", 0, null);
        }
        return map;
    }


}
