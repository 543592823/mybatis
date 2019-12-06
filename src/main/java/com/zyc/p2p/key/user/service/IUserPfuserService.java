package com.zyc.p2p.key.user.service;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.user.model.UserPfuser;

import java.util.List;

public interface IUserPfuserService {

    //查询所有用户信息
    List<UserPfuser> PfuserListPager(UserPfuser userPfuser, PageBean pageBean) throws Exception;

    //删除
    int delPfUser(UserPfuser userPfuser)throws Exception;

    //============================================龙娟=============================================================

    //根据用户名查账号信息
    UserPfuser listByUserName(String userName);


    //注册 (龙娟)
    int registerUser(UserPfuser userPfuser);

}