package com.zyc.p2p.key.audit.model;

import lombok.ToString;

import java.util.Date;

@ToString
public class AuditTask {
    private Integer auditId;

    private String realName;

    private String idNumber;

    private String phoneNumber;

    private Float loanManay;

    private Integer perlods;

    private Float refundManay;

    private Date loanTime;

    private String auditor;

    private String refundTime;

    private Integer overdueDay;

    private String state;

    public AuditTask(Integer auditId, String realName, String idNumber, String phoneNumber, Float loanManay, Integer perlods, Float refundManay, Date loanTime, String auditor, String refundTime, Integer overdueDay, String state) {
        this.auditId = auditId;
        this.realName = realName;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.loanManay = loanManay;
        this.perlods = perlods;
        this.refundManay = refundManay;
        this.loanTime = loanTime;
        this.auditor = auditor;
        this.refundTime = refundTime;
        this.overdueDay = overdueDay;
        this.state = state;
    }

    public AuditTask() {
        super();
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Float getLoanManay() {
        return loanManay;
    }

    public void setLoanManay(Float loanManay) {
        this.loanManay = loanManay;
    }

    public Integer getPerlods() {
        return perlods;
    }

    public void setPerlods(Integer perlods) {
        this.perlods = perlods;
    }

    public Float getRefundManay() {
        return refundManay;
    }

    public void setRefundManay(Float refundManay) {
        this.refundManay = refundManay;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}