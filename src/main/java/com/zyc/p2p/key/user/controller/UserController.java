package com.zyc.p2p.key.user.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.DxyzTest;
import com.zyc.p2p.base.util.JSONResult;
import com.zyc.p2p.base.util.PasswordHelper;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.user.model.UserPfuser;
import com.zyc.p2p.key.user.service.IUserPfuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController extends BaseAction{

    DxyzTest dxyz = new DxyzTest();

    @Autowired
    private static DxyzTest d = new DxyzTest();

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

    //================================龙娟============================================

    @ModelAttribute
    public void init(Model model){
        System.out.println("init......");

        UserPfuser userPfuser = new UserPfuser();
        model.addAttribute("userPfuser",userPfuser);


    }

    //检查登录名是否重复
//    @RequestMapping("/checkUsernameExist")
//    @ResponseBody
//    public boolean checkUsernameExist(String username){
//        return ! userPfuserService;
//    }

    //登录
    @RequestMapping(value = "/login")
    @ResponseBody
    public JSONResult login(UserPfuser userPfuser , HttpServletRequest request){
        JSONResult result = new JSONResult();
        userPfuser = userPfuserService.listByUserName(request.getParameter("userName"));
        if(userPfuser == null){
            result.mark("用户名或密码错误,请重新登录");
        }
        return result;
    }
    //退出
    @RequestMapping(value = "logout")
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
        request.getSession().invalidate();
        //注销应该跳转到首页，这里先跳转到登录页面，首页的一些数据还没有
        response.sendRedirect("/login.jsp");
    }



    //获取验证码
    @RequestMapping(value = "/Dxyz")
    public String Dxyz(HttpServletRequest request){
        String phoneNumber = request.getParameter("phoneNumber");
        System.out.println("phoneNumber=="+phoneNumber);
        dxyz.lj(phoneNumber);
        return "login";
    }



    //注册
    @RequestMapping(value = "/register")
    @ResponseBody
    public  Map<String, Object> register(UserPfuser userPfuser,HttpServletRequest request){
        Map<String, Object> map = null;
        String cs = dxyz.cs(userPfuser.getPhoneNumber());
        System.err.println("cs=="+cs);
        if("测试成功".equals(cs)){
            JSONResult result = new JSONResult();
            PasswordHelper p = new PasswordHelper();
            //盐//判断用户是否获取了验证码
            String salt = p.createSalt();
            //凭证+盐加密后得到的密码if("验证成功".equals(s)){
            String credentials = p.createCredentials(userPfuser.getPassword(), salt);
            userPfuser.setPassword(credentials);
            userPfuser.setSalt(salt);
            try {
                userPfuserService.registerUser(userPfuser);
                map = this.toMessage("注册成功",1,null);
            } catch (Exception e) {
                map = this.toMessage("注册失败",0,null);
            }
        }else{
            map = this.toMessage("验证码匹配不正确",0,null);
        }

        return map;
    }


}

