package com.zyc.p2p.key.charge.mapper;

import com.zyc.p2p.key.charge.model.ChargeRecord;

public interface ChargeRecordMapper {
    int insert(ChargeRecord record);

    int insertSelective(ChargeRecord record);
}