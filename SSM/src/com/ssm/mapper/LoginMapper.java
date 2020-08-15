package com.ssm.mapper;

import com.ssm.bean.Admin;
import com.ssm.bean.Market;
import com.ssm.bean.User;

public interface LoginMapper {
	
	//查询此Admin是否存在
	Admin selectAdmin(Integer did,String dpwd);
	//查询此User是否存在
	User selectUser(Integer uid,String upwd);
	//查询此Market是否存在
	Market selectMarket(Integer mid,String mpwd);
	// 查询是否存在此uid的User
	User getUserByUid(Integer uid);
	//用户注册
	void InsertUser(User user);
	// 查询是否存在此mid的Market
	Market getMarketByMid(Integer mid);
	//商家注册
	void InsertMarket(Market market);
}
