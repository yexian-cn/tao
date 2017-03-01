package com.xiaochun.tao.common.persistence;

import java.io.Serializable;

public class PageReq  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1847222057168940580L;
	
	
	private int pageSize=10; // 页大小
	private int totalPage;// 总页数
	private int currPage = 1;// 当前页数
	private int totalRecords;// 总条数
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	
	
	
}
