package com.zyc.p2p.key.sys.service.impl;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.sys.mapper.SysUserMapper;
import com.zyc.p2p.key.sys.model.SysUser;
import com.zyc.p2p.key.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser userLogin(String username) throws Exception {
        return this.sysUserMapper.userLogin(username);
    }

    @Override
    public Set<String> findRoles(String username) throws Exception {
        return this.sysUserMapper.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) throws Exception {
        return this.sysUserMapper.findPermissions(username);
    }

    @Override
    public int addSysUser(SysUser sysUser) throws Exception {
        return this.sysUserMapper.addSysUser(sysUser);
    }

    @Override
    public int uptSysUser(SysUser sysUser) throws Exception {
        return this.sysUserMapper.uptSysUser(sysUser);
    }

    @Override
    public int selMaxUserId() throws Exception {
        return this.sysUserMapper.selMaxUserId();
    }

    @Override
    public List<SysUser> selSysUserPager(SysUser sysUser, PageBean pageBean) throws Exception {
        return this.sysUserMapper.selSysUserPager(sysUser);
    }

    @Override
    public List<SysUser> lisUser() throws Exception {
        return this.sysUserMapper.lisUser();
    }

    @Override
    public int delSysUser(SysUser sysUser) throws Exception {
        return  this.sysUserMapper.delSysUser(sysUser);
    }
}
