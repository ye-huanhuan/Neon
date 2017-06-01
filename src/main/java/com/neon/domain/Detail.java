package com.neon.domain;

import java.util.Date;

public class Detail {

	private Long id;
	private String ein;//税号
	private String ReceUnit;//收款单位
	private String payUnit;//付款单位
	private String money;//金额
	private Date date;//日期
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEin() {
		return ein;
	}
	public String getReceUnit() {
		return ReceUnit;
	}
	public String getPayUnit() {
		return payUnit;
	}
	public String getMoney() {
		return money;
	}
	public Date getDate() {
		return date;
	}
	public void setEin(String ein) {
		this.ein = ein;
	}
	public void setReceUnit(String receUnit) {
		ReceUnit = receUnit;
	}
	public void setPayUnit(String payUnit) {
		this.payUnit = payUnit;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
