package com.wrq.vo;

import com.wrq.pojo.Category;

/**
 * 
 * CategoryVo
 * 创建人:mofeng
 * 时间：2018年9月26日-下午7:09:35
 * @version 1.0.0
 * 
 */
public class CategoryVo extends Category {

	private String orderBy;
	private Integer status = 1;
	private Integer isDelete = 0;
	private Integer pageNo = 0;
	private Integer pageSize = 10;
	private String keyword;
	private Integer filterId;

	

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getFilterId() {
		return filterId;
	}

	public void setFilterId(Integer filterId) {
		this.filterId = filterId;
	}
}
