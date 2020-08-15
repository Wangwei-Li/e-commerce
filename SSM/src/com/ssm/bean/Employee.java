package com.ssm.bean;

public class Employee {
	
	private Integer eid;
	private String ename;
	private Integer ephone;
	private String car;
	private String scope;
	
	
	public Employee() {
		super();
	}
	public Employee(Integer eid, String ename, Integer ephone, String car, String scope) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.ephone = ephone;
		this.car = car;
		this.scope = scope;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getEphone() {
		return ephone;
	}
	public void setEphone(Integer ephone) {
		this.ephone = ephone;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
}
