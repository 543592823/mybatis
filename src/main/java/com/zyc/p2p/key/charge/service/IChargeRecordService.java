package com.zyc.p2p.key.charge.service;

import com.zyc.p2p.key.charge.model.ChargeRecord;

public interface IChargeRecordService {
    int insert(ChargeRecord record) throws Exception;

    int insertSelective(ChargeRecord record) throws Exception;
}