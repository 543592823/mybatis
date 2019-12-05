package com.zyc.p2p.key.user.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.user.model.UserPfuser;
import com.zyc.p2p.key.user.service.IUserPfuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController extends BaseAction{

    @Autowired
    private IUserPfuserService userPfuserService;

    @RequestMapping(value = "/PfuserList")
    @ResponseBody
    public Map<String, Object> PfuserList(UserPfuser userPfuser,HttpServletRequest request){
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);

        try {
            List<UserPfuser> userPfusers = this.userPfuserService.PfuserListPager(userPfuser,pageBean);
            map = this.toPage("查询成功", 1, userPfusers,pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        return map;
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public Map<String, Object> delPfuser(UserPfuser userPfuser){
        Map<String, Object> map = null;
        try {
            this.userPfuserService.delPfUser(userPfuser);
            map = this.toMessage("删除成功", 1, null);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        return map;
    }


}

