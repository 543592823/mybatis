package com.zyc.p2p.key.user.service.impl;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.user.mapper.UserPfuserMapper;
import com.zyc.p2p.key.user.model.UserPfuser;
import com.zyc.p2p.key.user.service.IUserPfuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPfuserServiceImpl implements IUserPfuserService {

    @Autowired
    private UserPfuserMapper userPfuserMapper;

    @Override
    public List<UserPfuser> PfuserListPager(UserPfuser userPfuser, PageBean pageBean) throws Exception {
        return this.userPfuserMapper.PfuserListPager(userPfuser);
    }

    @Override
    public int delPfUser(UserPfuser userPfuser) throws Exception {
        return this.userPfuserMapper.delPfUser(userPfuser);
    }
}
