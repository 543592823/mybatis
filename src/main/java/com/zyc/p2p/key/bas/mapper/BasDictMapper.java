package com.zyc.p2p.key.bas.mapper;

import com.zyc.p2p.key.bas.model.BasDict;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasDictMapper {

    int insert(BasDict record) throws Exception;

    //修改
    int uptBasDict(BasDict record)throws Exception;

    //删除
    int delBasDict(BasDict record)throws Exception;

    //查询所有数据字典
    List<BasDict> doList() throws Exception;

    //带有模糊查询数据字典
    List<BasDict> basDictListPager(BasDict basDict) throws Exception;

}