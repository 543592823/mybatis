package com.zyc.p2p.base.action;

import com.zyc.p2p.base.util.PageBean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseAction {

	public Map<String, Object> toMessage(String message , Integer code, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(data != null) {
			map.put("result", data);
		}
		map.put("message", message);
		map.put("code", code);
		long date =new Date().getTime();
		map.put("ts", date);
		return map;
		}

	public Map<String, Object> toPage(String message , Integer code , Object data,PageBean pageBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(data != null) {
			map.put("result", data);
		}
		map.put("message", message);
		map.put("code", code);
		if(pageBean != null) {
			map.put("total", pageBean.getTotal());
			map.put("rows", pageBean.getRows());
		}
		long date =new Date().getTime();
		map.put("ts", date);
		return map;
	}
}
