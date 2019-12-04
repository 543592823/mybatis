package com.zyc.p2p.key.sys.mapper;

import com.zyc.p2p.key.sys.model.SysUser;
import com.zyc.p2p.key.sys.model.SysUserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleMapper {

    int addSysUser(SysUserRole sysUserRole) throws Exception;

    int selMaxUserId()throws Exception;

    int uptSysRole(SysUserRole sysUserRole)throws Exception;

    int delSysRole(SysUserRole sysUserRole)throws Exception;
}