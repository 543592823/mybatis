package com.zyc.p2p.key.pact.mapper;

import com.zyc.p2p.key.pact.model.PactUserpact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PactUserpactMapper {

    int insertPact(PactUserpact record)  throws Exception;

    //查询所有合同
    List<PactUserpact> selPactListPager(PactUserpact record)throws Exception;
}