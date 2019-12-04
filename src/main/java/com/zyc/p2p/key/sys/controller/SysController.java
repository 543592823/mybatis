package com.zyc.p2p.key.sys.controller;

import com.zyc.p2p.base.action.BaseAction;
import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.sys.model.SysUser;
import com.zyc.p2p.key.sys.model.SysUserRole;
import com.zyc.p2p.key.sys.service.ISysUserRoleService;
import com.zyc.p2p.key.sys.service.ISysUserService;
import com.zyc.p2p.key.sys.shiro.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/sys")
public class SysController extends BaseAction {

    @Autowired
    private ISysUserService sysUserMapper;

    @Autowired
    private ISysUserRoleService sysUserRoleMapper;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> userLogin(SysUser sysUser) {
        Map<String, Object> map = null;
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //创建用户密码toekn
        UsernamePasswordToken token = new UsernamePasswordToken(
                sysUser.getUsername(),
                sysUser.getPassword()
        );
        try {
            subject.login(token);//身份认证
        } catch (IncorrectCredentialsException e) {
            map = this.toMessage("密码错误", 0, null);
        } catch (UnknownAccountException e) {
            map = this.toMessage("账号错误", 0, null);
        } catch (Exception e) {
            map = this.toMessage("未登录不能进该界面", 0, null);
        }
        Set<String> roles = null;
        try {
            roles = sysUserMapper.findRoles(sysUser.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (map == null) {
            map = this.toMessage("登录成功", 1, roles);
        }
        return map;
    }


    @RequestMapping("/meger")
    @ResponseBody
    public Map<String, Object> addSysUser(SysUser sysUser, SysUserRole sysUserRole) throws Exception {
        Map<String, Object> map = null;
        List<SysUser> list = sysUserMapper.lisUser();
        Integer i = 0;
        for (SysUser user : list) {
            if (user.getUsername().equals(sysUser.getUsername())) {
                i = 1;
            }
        }
        PasswordHelper p = new PasswordHelper();
        //盐
        String salt = p.createSalt();
        //凭证+盐加密后得到的密码
        String credentials = p.createCredentials(sysUser.getPassword(), salt);
        sysUser.setPassword(credentials);
        sysUser.setSalt(salt);
        if (i == 0) {
        if (sysUser.getUserid() == null) {//增加
                try {
                    this.sysUserMapper.addSysUser(sysUser);
                    Integer userid = this.sysUserMapper.selMaxUserId();
                    sysUserRole.setUserid(userid);
                    sysUserRole.setRoleid(Integer.parseInt(sysUser.getRolename()));
                    this.sysUserRoleMapper.addSysUser(sysUserRole);
                    map = this.toMessage("增加成功", 1, null);
                } catch (Exception e) {
                    map = this.toMessage("增加失败", 0, null);
                }
        } else {//修改
            try {
                this.sysUserMapper.uptSysUser(sysUser);
                sysUserRole.setUserid(sysUser.getUserid());
                sysUserRole.setRoleid(Integer.parseInt(sysUser.getRolename()));
                this.sysUserRoleMapper.uptSysRole(sysUserRole);
                map = this.toMessage("修改成功", 1, null);
            } catch (Exception e) {
                map = this.toMessage("修改失败", 0, null);
            }
        }
        } else {
            map = this.toMessage("该员工账号已经存在", 0, null);
        }
        return map;
    }

    @RequestMapping("/sysList")
    @ResponseBody
    public Map<String, Object> selSysUser(SysUser sysUser, HttpServletRequest request) {
        Map<String, Object> map = null;
        PageBean pageBean = new PageBean();
        pageBean.inItRequest(request);
        try {
            List<SysUser> list = this.sysUserMapper.selSysUserPager(sysUser, pageBean);
            map = this.toPage("查询成功", 1, list, pageBean);
        } catch (Exception e) {
            map = this.toMessage("查询失败", 0, null);
        }
        return map;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> delSysUser(SysUser sysUser) {
        SysUserRole sysUserRole = new SysUserRole();
        Map<String, Object> map = null;
        try {
            this.sysUserMapper.delSysUser(sysUser);
            sysUserRole.setUserid(sysUser.getUserid());
            this.sysUserRoleMapper.delSysRole(sysUserRole);
            map = this.toMessage("删除成功", 1, null);
        } catch (Exception e) {
            map = this.toMessage("删除失败", 0, null);
        }
        return map;
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout() {
        //关键代码
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/toHome";
    }

}

