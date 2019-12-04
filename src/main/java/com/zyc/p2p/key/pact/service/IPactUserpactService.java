package com.zyc.p2p.key.pact.service;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.pact.model.PactUserpact;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPactUserpactService {

    int insertPact(PactUserpact record)  throws Exception;

    //查询所有合同
    List<PactUserpact> selPactListPager(PactUserpact record, PageBean pageBean)throws Exception;
}