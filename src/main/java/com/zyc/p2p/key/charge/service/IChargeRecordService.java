package com.zyc.p2p.key.charge.service;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.charge.model.ChargeRecord;

import java.util.List;

public interface IChargeRecordService {
    int insert(ChargeRecord record) throws Exception;
//
//    int insertSelective(ChargeRecord record) throws Exception;

    List<ChargeRecord> selChargePager(ChargeRecord record,PageBean pageBean) throws Exception;

    //逾期详情
    List<ChargeRecord> overdueDetails(ChargeRecord record,PageBean pageBean) throws Exception;

    int updateOverdue(ChargeRecord record) throws Exception;

    ChargeRecord singleList(ChargeRecord record) throws Exception;
}