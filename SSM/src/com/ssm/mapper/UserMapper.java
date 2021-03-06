package com.ssm.mapper;

import java.util.List;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Give;
import com.ssm.bean.Goods;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.bean.User;

public interface UserMapper {

	// 修改个人信息
	void updateMyUser(User user);

	// 查看所有商品
	List<Goods> userSelectAllGoods();

	// 获取此商品信息
	Goods userSelectGoods(Integer gid);

	// 购买商品，发出请求信息
	void insertBuyInfor(BuyInfor buyInfor);

	// 查看个人购买信息
	List<BuyInfor> selectUserBuyInfor(Integer uid);

	// 查看商家发货信息
	List<SendInfor> userSelectAllSendInfor(Integer uid);

	// 查看物品派送情况
	List<Give> userSelectGive(Integer uid);

	// 查看是否已签收此订单
	Integer userSelectOneReceive(Integer bid);

	// 签收物品，把信息存入签收表中
	void userInsertReceive(Integer bid, String rtime);

	// 查看已签收情况
	List<Receive> userSelectReceive(Integer uid);

	// 查看日志
	String userSelectLogs(Integer uid);

	// 查看是否存在
	Integer userSelectUserLog(Integer uid);

	// 修改日志
	void userUpdateLogs(String log, Integer uid);

	// 添加日志
	void userInsertLogs(Integer uid);
}
