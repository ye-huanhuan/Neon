package com.neon.domain;


public class Dvalue {

	private Long id;
	private Double pdvalue;//利润
	private Double ndvalue;//亏损
	private String date;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Double getPdvalue() {
		return pdvalue;
	}

	public Double getNdvalue() {
		return ndvalue;
	}

	public void setPdvalue(Double pdvalue) {
		this.pdvalue = pdvalue;
	}

	public void setNdvalue(Double ndvalue) {
		this.ndvalue = ndvalue;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	
}
