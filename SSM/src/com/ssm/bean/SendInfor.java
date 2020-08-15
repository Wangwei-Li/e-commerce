package com.ssm.bean;

public class SendInfor {
	
	private Integer sid;
	private BuyInfor buyinfor;
	
	public SendInfor() {
		super();
	}

	public SendInfor(Integer sid, BuyInfor buyinfor) {
		super();
		this.sid = sid;
		this.buyinfor = buyinfor;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public BuyInfor getBuyinfor() {
		return buyinfor;
	}

	public void setBuyinfor(BuyInfor buyinfor) {
		this.buyinfor = buyinfor;
	}
	
}
