package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Give;
import com.ssm.bean.Goods;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.bean.User;
import com.ssm.mapper.UserMapper;
import com.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void updateMyUser(User user) {
		userMapper.updateMyUser(user);

	}

	@Override
	public List<Goods> userSelectAllGoods() {
		return userMapper.userSelectAllGoods();
	}

	@Override
	public Goods userSelectGoods(Integer gid) {
		return userMapper.userSelectGoods(gid);

	}

	@Override
	public void insertBuyInfor(BuyInfor buyInfor) {
		userMapper.insertBuyInfor(buyInfor);
	}

	@Override
	public List<SendInfor> userSelectAllSendInfor(Integer uid) {
		return userMapper.userSelectAllSendInfor(uid);
	}

	@Override
	public List<BuyInfor> selectUserBuyInfor(Integer uid) {
		return userMapper.selectUserBuyInfor(uid);

	}

	@Override
	public List<Give> userSelectGive(Integer uid) {
		return userMapper.userSelectGive(uid);
	}

	@Override
	public void userInsertReceive(Integer bid,String rtime) {
		Integer result = userMapper.userSelectOneReceive(bid);
		if (result == null) {
			userMapper.userInsertReceive(bid,rtime);
		}
	}

	@Override
	public List<Receive> userSelectReceive(Integer uid) {
		return userMapper.userSelectReceive(uid);
	}

	@Override
	public String userSelectLogs(Integer uid) {
		Integer user = userMapper.userSelectUserLog(uid);
		if(user==null) {
			userMapper.userInsertLogs(uid);
		}
		return userMapper.userSelectLogs(uid);
	}

	@Override
	public void userUpdateLogs(String log, Integer uid) {
		userMapper.userUpdateLogs(log,uid);
	}

}
