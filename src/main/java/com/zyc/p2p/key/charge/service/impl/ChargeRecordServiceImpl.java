package com.zyc.p2p.key.charge.service.impl;

import com.zyc.p2p.base.util.PageBean;
import com.zyc.p2p.key.charge.mapper.ChargeRecordMapper;
import com.zyc.p2p.key.charge.model.ChargeRecord;
import com.zyc.p2p.key.charge.service.IChargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeRecordServiceImpl implements IChargeRecordService {

    @Autowired
    private ChargeRecordMapper chargeRecordMapper;

    @Override
    public int insert(ChargeRecord record) throws Exception {
        return this.chargeRecordMapper.insert(record);
    }
//
//    @Override
//    public int insertSelective(ChargeRecord record) throws Exception {
//        return this.chargeRecordMapper.insertSelective(record);
//    }

    @Override
    public List<ChargeRecord> selChargePager(ChargeRecord record,PageBean pageBean) throws Exception {
        return this.chargeRecordMapper.selChargePager(record);
    }

    @Override
    public List<ChargeRecord> overdueDetails(ChargeRecord record,PageBean pageBean) throws Exception {
        return chargeRecordMapper.overdueDetails(record);
    }

    @Override
    public int updateOverdue(ChargeRecord record) throws Exception {
        return chargeRecordMapper.updateOverdue(record);
    }
}
