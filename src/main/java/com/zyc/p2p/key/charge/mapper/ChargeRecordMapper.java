package com.zyc.p2p.key.charge.mapper;

import com.zyc.p2p.key.charge.model.ChargeRecord;

import java.util.List;

public interface ChargeRecordMapper {
    int insert(ChargeRecord record);

    int insertSelective(ChargeRecord record);

    List<ChargeRecord> selChargePager(ChargeRecord record) throws Exception;
}