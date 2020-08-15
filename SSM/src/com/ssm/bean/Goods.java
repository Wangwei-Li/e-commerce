package com.ssm.bean;

public class Goods {
	
	private Integer gid;
	private String gname;
	private Integer price;
	private Market market;
	
	public Goods() {
		super();
	}

	public Goods(Integer gid, String gname, Integer price, Market market) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.price = price;
		this.market = market;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}
	
}
