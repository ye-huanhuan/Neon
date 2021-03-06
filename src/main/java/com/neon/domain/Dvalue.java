package com.neon.domain;


public class Dvalue {

	private Long id;
	private Double pdvalue_month;//月利润
	private Double ndvalue_month;//月亏损
	private Double pdvalue_quarter;//季度利润
	private Double ndvalue_quarter;//季度亏损
	private Double pdvalue_year;//年利润
	private Double ndvalue_year;//年亏损
	private Double target_month;//月目标
	private Double target_quarter;//季度目标
	private Double target_year;//年目标
	private String date;
	
	public Double getTarget_month() {
		return target_month;
	}

	public Double getTarget_quarter() {
		return target_quarter;
	}

	public Double getTarget_year() {
		return target_year;
	}

	public void setTarget_month(Double target_month) {
		this.target_month = target_month;
	}

	public void setTarget_quarter(Double target_quarter) {
		this.target_quarter = target_quarter;
	}

	public void setTarget_year(Double target_year) {
		this.target_year = target_year;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getPdvalue_month() {
		return pdvalue_month;
	}

	public Double getNdvalue_month() {
		return ndvalue_month;
	}


	public Double getPdvalue_year() {
		return pdvalue_year;
	}

	public Double getPdvalue_quarter() {
		return pdvalue_quarter;
	}

	public Double getNdvalue_quarter() {
		return ndvalue_quarter;
	}

	public void setPdvalue_quarter(Double pdvalue_quarter) {
		this.pdvalue_quarter = pdvalue_quarter;
	}

	public void setNdvalue_quarter(Double ndvalue_quarter) {
		this.ndvalue_quarter = ndvalue_quarter;
	}

	public Double getNdvalue_year() {
		return ndvalue_year;
	}

	public void setPdvalue_month(Double pdvalue_month) {
		this.pdvalue_month = pdvalue_month;
	}

	public void setNdvalue_month(Double ndvalue_month) {
		this.ndvalue_month = ndvalue_month;
	}


	public void setPdvalue_year(Double pdvalue_year) {
		this.pdvalue_year = pdvalue_year;
	}

	public void setNdvalue_year(Double ndvalue_year) {
		this.ndvalue_year = ndvalue_year;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	
}
