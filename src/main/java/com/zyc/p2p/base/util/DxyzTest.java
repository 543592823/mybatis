package com.zyc.p2p.base.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DxyzTest {


    public String RandomNote(){
        Random rd = new Random();
        Integer randomNum = rd.nextInt(1000000);
        String s = String.format("%06d", randomNum);
        return s;
    }

    //发送短信
    public String sendMsg(String mobile) {
        String host = "http://codesms.market.alicloudapi.com";
        String path = "/sms/send/template/code/70";
        String method = "POST";
        String appcode = "b8d5c15910c043d284267c81b16ff3cf";
        String Random = RandomNote();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>();
        querys.put("content", "【摩字】尊敬的用户你好,您本次的验证码为"+Random+"，您正在进行短信验证，请于60秒内完成验证，如非本人操作，请忽略此短信。");
        querys.put("mobile", mobile);
        Map<String, String> bodys = new HashMap<>();
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Random;
    }

    // ip地址
    String host = "192.168.119.136";
    // 端口号
    int port = 6379;
    Jedis jedis = new Jedis(host, port);

    public void Redis(){
//        RedisTemplate<String,Object> redisTemplate;
        jedis.auth("123456");
        jedis.ping();
        //选择数据库
        jedis.select(5);
    }

    public void setRun(String s,String key){
        jedis.set(key,s);
        jedis.expire(key,60);
    }

    public String getRun(String key){
        String run = jedis.get(key);
        return run;
    }

    //
    public void lj(String mobile){
//        mobile = "18711539016";
        String s = sendMsg(mobile);
//        String s = RandomNote();
        System.out.println("s=="+s);
//        //连接
        setRun(s,"name");
    }

    //验证码验证
    public String cs(String str){
        //测试
        String name = getRun("name");
//        System.out.println(name);
//        str = "246496";
        String message= "";
        if(str.equals(name)){
            message ="验证成功";
            System.out.println("验证成功");
        }else {
            message ="验证失败";
            System.out.println("验证码错误");
        }
        return message;
    }

}
