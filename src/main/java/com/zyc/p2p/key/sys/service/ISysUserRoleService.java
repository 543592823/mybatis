package com.zyc.p2p.key.sys.service;

import com.zyc.p2p.key.sys.model.SysUserRole;
import org.springframework.stereotype.Repository;

public interface ISysUserRoleService {

    int addSysUser(SysUserRole sysUserRole) throws Exception;

    int selMaxUserId()throws Exception;

    int uptSysRole(SysUserRole sysUserRole)throws Exception;

    int delSysRole(SysUserRole sysUserRole)throws Exception;
}