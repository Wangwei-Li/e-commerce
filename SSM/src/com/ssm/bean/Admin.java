package com.ssm.bean;

public class Admin {
	
	private Integer did;
	private String dpwd;
	
	public Admin() {
		super();
	}
	
	public Admin(Integer did, String dpwd) {
		super();
		this.did = did;
		this.dpwd = dpwd;
	}
	
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDpwd() {
		return dpwd;
	}
	public void setDpwd(String dpwd) {
		this.dpwd = dpwd;
	}
	
}
