package com.xiaochun.tao.common.dal.object;

import java.util.Date;

public class BaseConditionVO {
	public final static int PAGE_SHOW_COUNT = 10;//默认页数
	private int pageNum = 1;//默认第1页
	private int pageSize = 0;//页数
	private int totalCount = 0;//总条数
	private String orderField;//排序字段
	private String orderDirection;
	private String keywords;//检索条件
	private String status;//状态
	private String type;//类型
	private Date startDate;//开始时间
	private Date endDate;//结束时间
	
	public String getType() {
		return "".equals(type) ? null : type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return "".equals(status)? null : status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize > 0 ? pageSize : PAGE_SHOW_COUNT;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderDirection() {
		return "desc".equals(orderDirection) ? "desc" : "asc";
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public String getKeywords() {
		return "".equals(keywords)? null : keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public int getStartIndex() {
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		return pageNum * this.getPageSize();
	}
	
}
