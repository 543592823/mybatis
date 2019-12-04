package com.zyc.p2p.key.sys.mapper;

import com.zyc.p2p.key.sys.model.SysRole;
import com.zyc.p2p.key.sys.model.SysUser;
import com.zyc.p2p.key.sys.model.SysUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface SysUserMapper {
    SysUser userLogin(String username) throws Exception;

    //根据username查询该用户的所有角色，用于角色验证
    Set<String> findRoles(String username) throws Exception;

    //根据username查询他所拥有的权限信息，用于权限判断
    Set<String> findPermissions(String username) throws Exception;

    //增加员工
    int addSysUser(SysUser sysUser) throws Exception;

    //修改员工
    int uptSysUser(SysUser sysUser) throws Exception;

    List<SysUser> lisUser() throws Exception;

    int selMaxUserId()throws Exception;

    //查询所有员工信息
    List<SysUser> selSysUserPager(SysUser sysUser)throws Exception;

    //刪除员工
    int delSysUser(SysUser sysUser) throws Exception;
}