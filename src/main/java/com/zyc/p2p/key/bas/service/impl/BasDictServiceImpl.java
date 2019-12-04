package com.zyc.p2p.key.bas.service.impl;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.bas.mapper.BasDictMapper;
import com.zyc.p2p.key.bas.model.BasDict;
import com.zyc.p2p.key.bas.service.IBasDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasDictServiceImpl implements IBasDictService {

    @Autowired
    private BasDictMapper basDictMapper;

    @Override
    public int insert(BasDict record) throws Exception {
        return this.basDictMapper.insert(record);
    }

    @Override
    public int uptBasDict(BasDict record) throws Exception {
        return this.basDictMapper.uptBasDict(record);
    }

    @Override
    public int delBasDict(BasDict record) throws Exception {
        return this.basDictMapper.delBasDict(record);
    }

    @Override
    public List<BasDict> doList() throws Exception {
        return this.basDictMapper.doList();
    }

    @Override
    public List<BasDict> basDictListPager(BasDict basDict, PageBean pageBean) throws Exception {
        return this.basDictMapper.basDictListPager(basDict);
    }
}
