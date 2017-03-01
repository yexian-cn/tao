package com.xiaochun.tao.common.persistence;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageSize=10; // 页大小
	private int totalPage;// 总页数
	private int currPage = 1;// 当前页数
	private int totalRecords;// 总条数
	private int pageStart;//起始位置

	private List<T> pageList;

	private T object;

	public PageBean(PageReq page) {
		this.pageSize = page.getPageSize();
		this.currPage = page.getCurrPage();
	}

	public PageBean() {
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		int totalPage = 0;
		if (totalRecords % pageSize == 0) {
			totalPage = totalRecords / pageSize;
		} else {
			totalPage = totalRecords / pageSize + 1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return this.currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalRecords() {
		return this.totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}


	public String toString() {
		return "Page [pageSize=" + this.pageSize + ", totalPage="
				+ this.totalPage + ", currPage=" + this.currPage
				+ ", totalRecords=" + this.totalRecords + "]";
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public int getPageStart() {
		if(pageSize!=0){
			return (currPage-1)*pageSize;
		}
		return this.pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

}
