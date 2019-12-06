package com.zyc.p2p.base.util;

public class Test {

    public static void main(String[] args) {
        IdCard id = new IdCard();
        //身份证号码，长度只能为15或者18
        String idcard="430482200009219416";//
        boolean fale = id.getFalgByName(idcard);
        System.out.println(fale);
        if(fale == true){
            String sex= id.getGenderByIdCard(idcard);
            System.out.println("性别:" + sex);
            int age= id.getAgeByIdCard(idcard);
            System.out.println("年龄:" + age);
            String sr=id.getBirthByIdCard(idcard);
            System.out.println("生日:" + sr);
            String area = id.getGenderByArea(idcard);
            System.out.println("地址="+area);
        }else {
            System.out.println("身份证不合法");
        }

    }
    
}
