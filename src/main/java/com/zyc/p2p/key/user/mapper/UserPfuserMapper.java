package com.zyc.p2p.key.user.mapper;

import com.zyc.p2p.key.user.model.UserPfuser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPfuserMapper {

    //查询所有用户信息
    List<UserPfuser> PfuserListPager(UserPfuser userPfuser) throws Exception;

    //删除
    int delPfUser(UserPfuser userPfuser)throws Exception;

    //============================================龙娟=======================================================

    //根据用户名查账号信息
    UserPfuser listByUserName(String userName);

    //注册 (龙娟)
    int registerUser(UserPfuser userPfuser);



}