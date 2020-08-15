package com.ssm.service;

import com.ssm.bean.Admin;
import com.ssm.bean.Market;
import com.ssm.bean.User;

public interface LoginService {
	
	Admin selectAdmin(Integer did,String dpwd);
	
	User selectUser(Integer uid,String upwd);
	
	Market selectMarket(Integer mid,String mpwd);
	
	Boolean userEnrol(User user);
	
	Boolean marketEnrol(Market narket);
}
