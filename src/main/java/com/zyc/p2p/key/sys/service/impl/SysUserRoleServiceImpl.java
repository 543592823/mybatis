package com.zyc.p2p.key.sys.service.impl;

import com.zyc.p2p.key.sys.mapper.SysRoleMapper;
import com.zyc.p2p.key.sys.mapper.SysUserRoleMapper;
import com.zyc.p2p.key.sys.model.SysUserRole;
import com.zyc.p2p.key.sys.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int addSysUser(SysUserRole sysUserRole) throws Exception {
        return this.sysUserRoleMapper.addSysUser(sysUserRole);
    }

    @Override
    public int selMaxUserId() throws Exception {
        return this.sysUserRoleMapper.selMaxUserId();
    }

    @Override
    public int uptSysRole(SysUserRole sysUserRole) throws Exception {
        return this.sysUserRoleMapper.uptSysRole(sysUserRole);
    }

    @Override
    public int delSysRole(SysUserRole sysUserRole) throws Exception {
        return this.sysUserRoleMapper.delSysRole(sysUserRole);
    }
}
