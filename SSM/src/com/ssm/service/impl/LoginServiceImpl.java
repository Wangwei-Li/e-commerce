package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.bean.Admin;
import com.ssm.bean.Market;
import com.ssm.bean.User;
import com.ssm.mapper.LoginMapper;
import com.ssm.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginmapper;

	@Override
	public Admin selectAdmin(Integer did, String dpwd) {
		return loginmapper.selectAdmin(did, dpwd);
	}

	@Override
	public User selectUser(Integer uid, String upwd) {
		return loginmapper.selectUser(uid, upwd);
	}

	@Override
	public Market selectMarket(Integer mid, String mpwd) {
		return loginmapper.selectMarket(mid, mpwd);
	}

	@Override
	public Boolean userEnrol(User user) {
		 User userByUid = loginmapper.getUserByUid(user.getUid());
		 if(userByUid!=null) {
			 return false;
		 }else {
			 loginmapper.InsertUser(user);
			 return true;
		 }
	}

	@Override
	public Boolean marketEnrol(Market market) {
		Market marketByMid = loginmapper.getMarketByMid(market.getMid());
		if(marketByMid!=null) {
			return false;
		}else {
			loginmapper.InsertMarket(market);
			return true;
		}
	}
	
}
