package com.neon.domain;

public class Input {

	private Long id;
	private String item;
	private int month;
	private double money;
	private int year;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Long getId() {
		return id;
	}
	public String getItem() {
		return item;
	}
	public int getMonth() {
		return month;
	}
	public double getMoney() {
		return money;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
}
