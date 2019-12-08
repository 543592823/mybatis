package com.zyc.p2p.key.charge.model;

import lombok.ToString;

@ToString
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

    public ChargeRecord(String realName, String idNumber, Integer perlods, Float currentReturn, Float capital, Float serviceCost, Float interest, String state, String chargeDate, String refundDate,Long overdueCount,Long overdueCost) {
        this.realName = realName;
        this.idNumber = idNumber;
        this.perlods = perlods;
        this.currentReturn = currentReturn;
        this.capital = capital;
        this.serviceCost = serviceCost;
        this.interest = interest;
        this.state = state;
        this.chargeDate = chargeDate;
        this.refundDate = refundDate;
        this.overdueCount=overdueCount;
        this.overdueCost=overdueCost;
    }

    public ChargeRecord() {
        super();
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

    public Integer getPerlods() {
        return perlods;
    }

    public void setPerlods(Integer perlods) {
        this.perlods = perlods;
    }

    public Float getCurrentReturn() {
        return currentReturn;
    }

    public void setCurrentReturn(Float currentReturn) {
        this.currentReturn = currentReturn;
    }

    public Float getCapital() {
        return capital;
    }

    public void setCapital(Float capital) {
        this.capital = capital;
    }

    public Float getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Float serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    public String getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(String refundDate) {
        this.refundDate = refundDate;
    }

    public Long getOverdueCount() {
        return overdueCount;
    }

    public void setOverdueCount(Long overdueCount) {
        this.overdueCount = overdueCount;
    }

    public Long getOverdueCost() {
        return overdueCost;
    }

    public void setOverdueCost(Long overdueCost) {
        this.overdueCost = overdueCost;
    }
}