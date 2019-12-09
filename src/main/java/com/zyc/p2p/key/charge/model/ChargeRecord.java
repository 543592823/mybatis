package com.zyc.p2p.key.charge.model;

import lombok.Data;
import lombok.ToString;

@Data
public class ChargeRecord {
    private String realName;

    private String idNumber;

    private Integer perlods;

    private Float currentReturn;

    private Float capital;

    private Float serviceCost;

    private Float interest;

    private String state;

    private String chargeDate;

    private String refundDate;

    private Long overdueCount;

    private Long overdueCost;

    private Float loanManay;
}