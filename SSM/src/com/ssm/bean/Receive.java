package com.ssm.bean;

public class Receive {
	
	private Integer rid;
	private BuyInfor buy;
	private String rtime;
	
	public Receive() {
		super();
	}

	public Receive(Integer rid, BuyInfor buy, String rtime) {
		super();
		this.rid = rid;
		this.buy = buy;
		this.rtime = rtime;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public BuyInfor getBuy() {
		return buy;
	}

	public void setBuy(BuyInfor buy) {
		this.buy = buy;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	
	
}
