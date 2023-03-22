package com.search.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;



public class ParamVO implements Serializable{

	private static final long serialVersionUID = 2255306964575116998L;
	
	@NotEmpty(message = "검색어는 필수값입니다. (query)")
	private String query;		// 검색어
	
	private String sort;		// 정렬
	
	private Integer page = 1;		// 페이지 번호 (기본값: 1)
	
	private Integer size = 10;		// 페이지에 보여질 수 (기본값: 10)

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	
}
