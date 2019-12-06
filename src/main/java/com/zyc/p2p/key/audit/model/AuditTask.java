package com.zyc.p2p.key.audit.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
public class AuditTask {
    private Integer auditId;

    private String realName;

    private String idNumber;

    private String phoneNumber;

    private Float loanManay;

    private Integer perlods;

    private Float refundManay;

    private String loanTime;

    private String auditor;

    private String refundTime;

    private Integer overdueDay;

    private String state;

}