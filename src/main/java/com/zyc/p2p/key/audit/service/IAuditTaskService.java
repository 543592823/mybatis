package com.zyc.p2p.key.audit.service;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.audit.model.AuditTask;

import java.util.List;

public interface IAuditTaskService {

    int insert(AuditTask record) throws Exception;

    //审核任务
    List<AuditTask> tackListPager(AuditTask auditTask, PageBean pageBean) throws Exception;

    //我的审核任务
    List<AuditTask> myTackListPager(AuditTask auditTask, PageBean pageBean) throws Exception;

    //放款复核
    List<AuditTask> putTackListPager(AuditTask auditTask,PageBean pageBean) throws Exception;

}