package com.ssm.bean;

public class BuyInfor {
	
	private Integer bid;
	private Goods goods;
	private User user;
	private String recipient;
	private Integer phone;
	private String raddress;
	
	public BuyInfor() {
		super();
	}
	
	public BuyInfor(Integer bid,Goods goods, User user, String recipient, Integer phone, String raddress) {
		super();
		this.bid = bid;
		this.goods = goods;
		this.user = user;
		this.recipient = recipient;
		this.phone = phone;
		this.raddress = raddress;
	}
	
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getRaddress() {
		return raddress;
	}

	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	
}
