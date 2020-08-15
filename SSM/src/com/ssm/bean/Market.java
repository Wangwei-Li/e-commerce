package com.ssm.bean;

public class Market {
	
	private Integer mid;
	private String mpwd;
	private String mname;
	private String maddress;
	
	public Market() {
		super();
	}
	
	public Market(Integer mid, String mpwd, String mname, String maddress) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.mname = mname;
		this.maddress = maddress;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

}
