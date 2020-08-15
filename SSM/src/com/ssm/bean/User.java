package com.ssm.bean;

public class User {
	
	private Integer uid;
	private String upwd;
	private String uname;
	private String sex;
	private String year;
	private String uaddress;
	
	public User() {
		super();
	}

	public User(Integer uid, String upwd, String uname, String sex, String year, String uaddress) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.uname = uname;
		this.sex = sex;
		this.year = year;
		this.uaddress = uaddress;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	
}
