package com.zyc.p2p.key.user.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.DxyzTest;
import com.zyc.p2p.base.util.JSONResult;
import com.zyc.p2p.base.util.PasswordHelper;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.user.model.UserPfuser;
import com.zyc.p2p.key.user.service.IUserPfuserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController extends BaseAction{

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

//    @RequestMapping(value = "/login")
//    public String login(UserPfuser userPfuser , HttpServletRequest request){
//        String message = null;
//        String userName = userPfuser.getUserName();
//        String password = userPfuser.getPassword();
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
//        try {
//            subject.login(token);
//        } catch (IncorrectCredentialsException e) {
//            message = "密码错误";
//            e.printStackTrace();
//        }catch(UnknownAccountException e){
//            message = "账号错误";
//        }catch (Exception e){
//            message = "账号或密码错误";
//        }
//
//        if(null == message){
//            return "index";
//
//        }else{
//            request.setAttribute("message",message);
//            return "login";
//        }
//
//    }

    @RequestMapping("/login")
    @ResponseBody
    public JSONResult login(UserPfuser userPfuser , HttpServletRequest request){
        JSONResult result = new JSONResult();
        UserPfuser currentUser = userPfuserService.listByUserName(request.getParameter("userName"));
        if(currentUser == null){
            result.mark("用户名或密码错误,请重新登录");
        }
        return result;
    }
    @RequestMapping("logout")
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
        request.getSession().invalidate();
        //注销应该跳转到首页，这里先跳转到登录页面，首页的一些数据还没有
        response.sendRedirect("/login.jsp");
    }



    @RequestMapping(value = "/register")

    public String register(@Validated @ModelAttribute UserPfuser userPfuser,HttpServletRequest request,BindingResult bindingResult){

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        userPfuser.setPassword(password);
        String phoneNumber = request.getParameter("phoneNumber");
        PasswordHelper p = new PasswordHelper();
        //盐
        String salt = p.createSalt();
        //凭证+盐加密后得到的密码
        String credentials = p.createCredentials(password, salt);
        userPfuser.setPassword(credentials);
        userPfuser.setSalt(salt);
        // 服务器端校验不通过
        if (bindingResult.hasErrors()) {
            return "register";
        }else{
            this.userPfuserService.registerUser(userPfuser);
            return "login";//逻辑视图名
        }



    }

//    @RequestMapping(value = "/register")
//    @ResponseBody
//    public JSONResult register(@Validated @ModelAttribute UserPfuser userPfuser,HttpServletRequest request){
//        JSONResult json = new JSONResult();
//        PasswordHelper p = new PasswordHelper();
//        //盐//判断用户是否获取了验证码
//         String salt = p.createSalt();
//      //凭证+盐加密后得到的密码if("验证成功".equals(s)){
//         String credentials = p.createCredentials(userPfuser.getPassword(), salt);
//        userPfuser.setPassword(credentials);
//        userPfuser.setSalt(salt);
//
//        String s = d.RandomNote();
//         if("s".equals(s)){
//                json.setSuccess(true);
//                json.setMsg("验证码正确");
//        }else{
//            json.setSuccess(false);
//            json.setMsg("验证码错误");
//        }
//
//        return json;
//    }



}

