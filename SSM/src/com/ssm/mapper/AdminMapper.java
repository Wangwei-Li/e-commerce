package com.ssm.mapper;

import java.util.List;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Employee;
import com.ssm.bean.Give;
import com.ssm.bean.Market;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.bean.User;

public interface AdminMapper {

	// 获取所有User信息
	List<User> getAllUser();

	// 查询为此uid的User
	User getUserByUid(Integer uid);

	// 修改User信息
	void UpdateUser(User user);

	// 添加User
	void InsertUser(User user);

	// 删除User
	void DeleteUser(Integer uid);

	// 获取所有Market信息
	List<Market> getAllMarket();

	// 查询为此mid的Market
	Market getMarketByMid(Integer mid);

	// 修改Market信息
	void UpdateMarket(Market market);

	// 添加Market
	void InsertMarket(Market market);

	// 删除Market
	void DeleteMarket(Integer mid);

	// 获取所有Buyinfor
	List<BuyInfor> SelectAllBuyInfor();
	
	//获取指定BuyInfor
	BuyInfor selectBuyInfor(Integer bid);

	// 获取所有商家发货信息
	List<SendInfor> SelectAllSendInfor();

	// 查看所有送货员工
	List<Employee> selectAllEmp();

	// 添加送货员工
	void insertEmp(Employee emp);

	// 查询为此mid的Market
	Employee getEmpByEid(Integer eid);

	// 修改送货员工信息
	void updateEmp(Employee emp);

	// 删除送货员工
	void deleteEmp(Integer eid);
	
	//在配送表中查看是否存在此订单
	Give selectOneGive(Integer bid);
	//添加配送信息
	void insertGiveInfor(Give give);
	//查看配送信息
	List<Give> selectAllGiveInfor();
	//查看被签收订单
	List<Receive> selectAllReceive();
}
