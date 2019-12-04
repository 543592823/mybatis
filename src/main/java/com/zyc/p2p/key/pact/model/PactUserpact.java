package com.zyc.p2p.key.pact.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
public class PactUserpact {
    private Integer pactId;

    private String realName;

    private String idNumber;

    private String phoneNumber;

    private Float loanManay;

    private Integer perlods;

    private String loanTime;

}