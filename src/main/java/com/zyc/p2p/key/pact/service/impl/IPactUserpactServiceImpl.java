package com.zyc.p2p.key.pact.service.impl;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.pact.mapper.PactUserpactMapper;
import com.zyc.p2p.key.pact.model.PactUserpact;
import com.zyc.p2p.key.pact.service.IPactUserpactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPactUserpactServiceImpl implements IPactUserpactService {

    @Autowired
    private PactUserpactMapper pactUserpactMapper;

    @Override
    public int insertPact(PactUserpact record) throws Exception {
        System.err.println("record=="+record);
        return this.pactUserpactMapper.insertPact(record);
    }

    @Override
    public List<PactUserpact> selPactListPager(PactUserpact record, PageBean pageBean) throws Exception {
        return this.pactUserpactMapper.selPactListPager(record);
    }

    @Override
    public int delPact(PactUserpact record) throws Exception {
        return this.pactUserpactMapper.delPact(record);
    }


}
