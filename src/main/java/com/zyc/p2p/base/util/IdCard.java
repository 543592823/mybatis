package com.zyc.p2p.base.util;

import java.util.Calendar;
import java.util.regex.Pattern;

public class IdCard {
    /**
     * 中国公民身份证号码最小长度。
     */
    public final int CHINA_ID_MIN_LENGTH = 15;

    /**
     * 中国公民身份证号码最大长度。
     */
    public final int CHINA_ID_MAX_LENGTH = 18;

    /**
     * 根据身份编号获取年龄
     *
     * @param idCard 身份编号
     * @return 年龄
     */
    public int getAgeByIdCard(String idCard) {
        int iAge = 0;
        Calendar cal = Calendar.getInstance();
        //年
        String year = idCard.substring(6, 10);
        //月
        String month = idCard.substring(10, 12);
        //天
        String day = idCard.substring(12, 14);

        int iCurrYear = cal.get(Calendar.YEAR);
        int iCurrMonth = cal.get(Calendar.MONTH) + 1;
        int iCurrDay = cal.get(Calendar.DATE);
        iAge = iCurrYear - Integer.valueOf(year);
        if (Integer.valueOf(month) > iCurrMonth) {
            iAge = iAge - 1;
        } else if (Integer.valueOf(month) == iCurrMonth) {
            if (Integer.valueOf(day) > iCurrDay) {
                System.out.println(100);
                iAge = iAge - 1;
            }
        }
        return iAge;
    }

    /**
     * 根据身份判断身份证是否合法
     *
     * @param idCard
     * @return falg
     */
    public boolean getFalgByName(String idCard) {
        //获取身份证长度
        Integer len = idCard.length();
        boolean falg = false;
        if (len == 15 || len == 18 ) {//判断身份证长度是否正确
            String s;
            String z;
            String x;
            if(len == 15){
                //身份证长度是15位，则取前14位，否则取前17位
                s = idCard.substring(0, 14);
                //取身份证号码中最后一位
                x = idCard.substring(14, 15);
                z = "^\\d{14}$";
            }else {
                s = idCard.substring(0, 17);
                x = idCard.substring(17, 18);
                z = "^\\d{17}$";
            }
            boolean matches2 = false;
            if(x.contains("x")){//判断身份证最后一位只能是x或者数字0-9
                matches2 = true;
            } else {
                if(Pattern.matches("^\\d{1}$", x) == true && Integer.parseInt(x) >=0){
                    matches2 = true;
                }
            }
            //其前14位或者17位只能为数字
            boolean matches = Pattern.matches(z, s);
            if(matches == true && matches2 == true){
                //获取身份证中的年龄
                int age = this.getAgeByIdCard(idCard);
                //获取身份证中的月份
                String a = this.getMonthByIdCard(idCard).toString();
                Integer month = Integer.parseInt(a);
                //获取身份证中的日
                String b = this.getDateByIdCard(idCard).toString();
                Integer date = Integer.parseInt(b);
                //获取身份证中的年
                String c = this.getYearByIdCard(idCard).toString();
                Integer year = Integer.parseInt(c);
                //获取身份证中的地址
                String area = getGenderByArea(idCard);
                Integer yue = 0;
                //获取每月对应的最大天数
                Integer i = this.Yue(month);
                //判断是否是平年或者闰年
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    if(month==2){
                        i += 1 ;
                    }
                }
                if (age > 0 && !area.contains("null") && month > 0 && month <= 12 && date > 0 && date <= i) {
                    falg = true;
                }
            }
        }
        return falg;
    }

    /**
     * 根据身份编号获取生日
     *
     * @param idCard 身份编号
     * @return 生日(yyyyMMdd)
     */
    public String getBirthByIdCard(String idCard) {
        //年
        String year = idCard.substring(6, 10);
        //月
        String month = idCard.substring(10, 12);
        //天
        String day = idCard.substring(12, 14);
        return year + "年" + month + "月" + day + "日";//idCard.substring(6, 14)
    }

    /**
     * 根据身份编号获取生日年
     *
     * @param idCard 身份编号
     * @return 生日(yyyy)
     */
    public Short getYearByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(6, 10));
    }

    /**
     * 根据身份编号获取生日月
     *
     * @param idCard 身份编号
     * @return 生日(MM)
     */
    public Short getMonthByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(10, 12));
    }

    /**
     * 根据身份编号获取生日天
     *
     * @param idCard 身份编号
     * @return 生日(dd)
     */
    public Short getDateByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(12, 14));
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard 身份编号
     * @return 性别(M - 男 ， F - 女 ， N - 未知)
     */
    public String getGenderByIdCard(String idCard) {
        String sGender = "未知";
        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "男";//男
        } else {
            sGender = "女";//女
        }
        return sGender;
    }

    /**
     * 根据身份编号获取省市区
     *
     * @param idCard 身份编号
     * @return area
     */
    public String getGenderByArea(String idCard) {
        Area a = new Area();
        String province = idCard.substring(0, 2);
        String crty = idCard.substring(0, 4);
        String region = idCard.substring(0, 6);
        String p = a.getNameString(province);
        String c = a.getNameString(crty);
        String r = a.getNameString(region);
        return p + c + r;
    }

    public Integer Yue(Integer month) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }



}
