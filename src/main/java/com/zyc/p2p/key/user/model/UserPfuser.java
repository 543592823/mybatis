package com.zyc.p2p.key.user.model;

import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ToString
public class UserPfuser {
    private Integer userId;

    //    @NotBlank(message = "用户名不能为空")
    private String userName;

    //    @Size(min = 6, max = 30, message = "密码长度应当在 6 ~ 30 个字符之间")
    private String password;


    private String salt;

    //    @Pattern(regexp = "/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$/")  //被注释的元素必须符合指定的正则表达式
    private String phoneNumber;

    private Integer score;

    private String realName;

    private String bankNumber;

    private String idNumber;

    private String incomeGrade;

    private String marriage;

    private String kidCount;

    private String educationBackground;

    private String houseCondition;

    private String email;

    public UserPfuser(Integer userId, String userName, String password, String salt, String phoneNumber, Integer score, String realName, String bankNumber, String idNumber, String incomeGrade, String marriage, String kidCount, String educationBackground, String houseCondition, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.phoneNumber = phoneNumber;
        this.score = score;
        this.realName = realName;
        this.bankNumber = bankNumber;
        this.idNumber = idNumber;
        this.incomeGrade = incomeGrade;
        this.marriage = marriage;
        this.kidCount = kidCount;
        this.educationBackground = educationBackground;
        this.houseCondition = houseCondition;
        this.email = email;
    }

    public UserPfuser() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIncomeGrade() {
        return incomeGrade;
    }

    public void setIncomeGrade(String incomeGrade) {
        this.incomeGrade = incomeGrade;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getKidCount() {
        return kidCount;
    }

    public void setKidCount(String kidCount) {
        this.kidCount = kidCount;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getHouseCondition() {
        return houseCondition;
    }

    public void setHouseCondition(String houseCondition) {
        this.houseCondition = houseCondition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}