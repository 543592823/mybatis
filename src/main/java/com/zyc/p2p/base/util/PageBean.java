package com.zyc.p2p.base.util;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.xml.internal.security.Init;

public class PageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2242403782746129991L;
	// 页码 
	private int page = 1;
	// 每页显示多少记录
	private int rows = 10;
	// 总记录数
	private long total = 0L;
	// 分页标记
	private boolean pagination = true;// 默认为true
	// 集合
	private Map<String, String[]> paraValues;
	// 地址
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String[]> getParaValues() {
		return paraValues;
	}

	public void setParaValues(Map<String, String[]> paraValues) {
		this.paraValues = paraValues;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	public void setPage(String page) {
		if (page != null) {
			this.page = Integer.parseInt(page);
		}
	}
	
	public void setTotal(String total) {
		if (total != null) {
			this.total = Long.parseLong(total);
		}
	}

	public void setRows(String rows) {
		if (rows != null) {
			this.rows = Integer.parseInt(rows);
		}
	}

	public void setPagination(String pagination) {
		if (pagination != null) {
			this.pagination = Boolean.parseBoolean(pagination);
		}
	}
	 //获取分页的起始位置
	 public int getStarIndex(){
		 return (this.page-1)*this.rows;  //limit 0,10;
	 }
	public void inItRequest(HttpServletRequest request) {
		setPage(request.getParameter("page"));
		setRows(request.getParameter("rows"));
		setPagination(request.getParameter("pagination"));
		paraValues = request.getParameterMap();
		url = request.getRequestURI();
	}

	public long upPage() {
		return this.page - 1 > 1 ? this.page - 1 : 1;
	}

	public long nextPage() {
		return this.page + 1 > maxPage() ? maxPage() : this.page+1;
	}

	public long maxPage() {
		return total % rows == 0 ? total / rows : (total / rows) + 1;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination
				+ ", para=" + paraValues.toString() + ", url=" + url + "]";
	}

}
