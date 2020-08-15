package com.ssm.bean;

public class Give {

	private Integer gvid;
	private Employee emp;
	private BuyInfor buy;
	private String gtime;

	public Give() {
		super();
	}


	public Give(Integer gvid, Employee emp, BuyInfor buy, String gtime) {
		super();
		this.gvid = gvid;
		this.emp = emp;
		this.buy = buy;
		this.gtime = gtime;
	}


	public Integer getGvid() {
		return gvid;
	}

	public void setGvid(Integer gvid) {
		this.gvid = gvid;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public BuyInfor getBuy() {
		return buy;
	}

	public void setBuy(BuyInfor buy) {
		this.buy = buy;
	}


	public String getGtime() {
		return gtime;
	}


	public void setGtime(String gtime) {
		this.gtime = gtime;
	}

}
