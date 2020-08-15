package com.ssm.mapper;

import com.ssm.bean.Admin;
import com.ssm.bean.Market;
import com.ssm.bean.User;

public interface LoginMapper {
	
	//��ѯ��Admin�Ƿ����
	Admin selectAdmin(Integer did,String dpwd);
	//��ѯ��User�Ƿ����
	User selectUser(Integer uid,String upwd);
	//��ѯ��Market�Ƿ����
	Market selectMarket(Integer mid,String mpwd);
	// ��ѯ�Ƿ���ڴ�uid��User
	User getUserByUid(Integer uid);
	//�û�ע��
	void InsertUser(User user);
	// ��ѯ�Ƿ���ڴ�mid��Market
	Market getMarketByMid(Integer mid);
	//�̼�ע��
	void InsertMarket(Market market);
}
