package com.spring.jqgrid.jqgrid.util;

import java.io.Serializable;
import java.util.List;

public class JQGridTable<T extends Serializable> {

	/**
	 * Current page of the query
	 */
	private String page;
	
	/**
	 * Total pages for the query
	 */
	private String total;
	
	/**
	 * Total number of records for the query
	 */
	private String records;
	
	/**
	 * An array containing the actual data
	 */
	private List<?> rows;

	public JQGridTable() {}
	
	public String getPage() {
		return page;
	}
	
	public void setPage(String page) {
		this.page = page;
	}

	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

	public String getRecords() {
		return records;
	}
		
	public void setRecords(String records) {
		this.records = records;
	}
	
	public List<?> getRows() {
		return rows;
	}
	
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
