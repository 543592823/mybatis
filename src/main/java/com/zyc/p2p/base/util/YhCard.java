package com.zyc.p2p.base.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class YhCard {
    public static void main(String[] args) {
        String host = "https://3bankcard.market.alicloudapi.com";
        String path = "/getapilist/";
        String method = "POST";
        String appcode = "b8d5c15910c043d284267c81b16ff3cf";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("card_number", "6230901804090634868");//6228480809436701373
        querys.put("id_number", "4304822000109219416");//430482200004143715
        querys.put("name", "陈星宇");
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response.toString());
            //获取response的body
//            String string = EntityUtils.toString(response.getEntity());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
