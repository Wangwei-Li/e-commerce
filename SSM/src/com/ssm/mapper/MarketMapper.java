package com.ssm.mapper;

import java.util.List;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Give;
import com.ssm.bean.Goods;
import com.ssm.bean.Market;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;

public interface MarketMapper {
	
	//显示自身信息
	Market selectMyMarket(Integer mid);
	
	//修改自身信息
	void updateMyMarket(Market market);
	
	//查看自身含有商品
	List<Goods> selectMyGoods(Integer mid);
	
	//根据商品编号查询商品
	Goods selectOne(Integer gid);
	
	//添加商品
	void insertGoods(Goods goods);
	
	//修改商品
	void updateGoods(Goods goods);
	
	//删除商品
	void deleteGoods(Integer gid);
	
	//查看所有购货请求
	List<BuyInfor> selectBuyInfors(Integer mid);
	
	//根据购买信息编号查看是否已处理此条信息
	SendInfor selectResult(Integer bid);
	
	//添加发货信息
	void insertSendInfor(Integer bid);
	
	//查看所有发货信息
	List<SendInfor> selectSendInfors(Integer mid);
	
	//查看已被派送订单
	List<Give> marketSelectGive(Integer mid);
	//查看已被签收订单
	List<Receive> marketSelectReceive(Integer mid);
	
	//查看日志
	String marketSelectLogs(Integer mid);
	//查看是否存在
	Integer marketSelectMarketLog(Integer mid);
	//修改日志
	void marketUpdateLogs(String log,Integer mid);
	//添加日志
	void marketInsertLogs(Integer mid);
}
