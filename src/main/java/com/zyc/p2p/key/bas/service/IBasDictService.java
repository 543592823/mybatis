package com.zyc.p2p.key.bas.service;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.bas.model.BasDict;

import java.util.List;

public interface IBasDictService {

    int insert(BasDict record) throws Exception;

    //修改
    int uptBasDict(BasDict record)throws Exception;

    //删除
    int delBasDict(BasDict record)throws Exception;

    //查询所有数据字典
    List<BasDict> doList() throws Exception;

    //带有模糊查询数据字典
    List<BasDict> basDictListPager(BasDict basDict, PageBean pageBean) throws Exception;

}