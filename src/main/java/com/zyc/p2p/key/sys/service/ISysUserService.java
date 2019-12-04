package com.zyc.p2p.key.sys.service;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.sys.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ISysUserService {
    SysUser userLogin(String username) throws Exception;

    //根据username查询该用户的所有角色，用于角色验证
    Set<String> findRoles(String username) throws Exception;

    //根据username查询他所拥有的权限信息，用于权限判断
    Set<String> findPermissions(String username) throws Exception;

    int addSysUser(SysUser sysUser) throws Exception;

    //修改员工
    int uptSysUser(SysUser sysUser) throws Exception;

    int selMaxUserId()throws Exception;

    List<SysUser> selSysUserPager(SysUser sysUser,PageBean pageBean) throws Exception;

    List<SysUser> lisUser() throws Exception;

    //刪除员工
    int delSysUser(SysUser sysUser) throws Exception;

}