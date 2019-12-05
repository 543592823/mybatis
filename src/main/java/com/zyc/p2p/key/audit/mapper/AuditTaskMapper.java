package com.zyc.p2p.key.audit.mapper;

import com.zyc.p2p.key.audit.model.AuditTask;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditTaskMapper {

    int insert(AuditTask record) throws Exception;

    //查询审核任务
    List<AuditTask> tackListPager(AuditTask auditTask) throws Exception;

    //查询我的审核任务
    List<AuditTask> myTackListPager(AuditTask auditTask) throws Exception;

    //查询放款复核
    List<AuditTask> putTackListPager(AuditTask auditTask) throws Exception;

    //审核任务
    int uptTackState(AuditTask auditTask) throws Exception;

}