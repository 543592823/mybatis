package com.zyc.p2p.key.audit.service.impl;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.audit.mapper.AuditTaskMapper;
import com.zyc.p2p.key.audit.model.AuditTask;
import com.zyc.p2p.key.audit.service.IAuditTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditTaskServiceImpl implements IAuditTaskService {

    @Autowired
    private AuditTaskMapper auditTaskMapper;

    @Override
    public int insert(AuditTask record) throws Exception{
        return this.auditTaskMapper.insert(record);
    }

    @Override
    public List<AuditTask> tackListPager(AuditTask auditTask, PageBean pageBean) throws Exception {
        return this.auditTaskMapper.tackListPager(auditTask);
    }

    @Override
    public List<AuditTask> myTackListPager(AuditTask auditTask, PageBean pageBean) throws Exception {
        return this.auditTaskMapper.myTackListPager(auditTask);
    }

    @Override
    public List<AuditTask> putTackListPager(AuditTask auditTask, PageBean pageBean) throws Exception {
        return this.auditTaskMapper.putTackListPager(auditTask);
    }

    @Override
    public int uptPut(AuditTask auditTask) throws Exception {
        return auditTaskMapper.uptPut(auditTask);
    }

    @Override
    public int uptTackState(AuditTask auditTask) throws Exception {
        return this.auditTaskMapper.uptTackState(auditTask);
    }

    @Override
    public List<AuditTask> loanListPager(AuditTask auditTask,PageBean pageBean) throws Exception {
        return this.auditTaskMapper.loanListPager(auditTask);
    }

    @Override
    public List<AuditTask> overdueList(AuditTask auditTask,PageBean pageBean) throws Exception {
        return auditTaskMapper.overdueList(auditTask);
    }


}
