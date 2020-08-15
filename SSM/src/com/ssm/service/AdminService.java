package com.ssm.service;

import java.util.List;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Employee;
import com.ssm.bean.Give;
import com.ssm.bean.Market;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.bean.User;

public interface AdminService {

	List<User> getAllUser();

	User getUserByUid(Integer uid);

	void UpdateUser(User user);

	void DeleteUser(Integer uid);

	List<Market> getAllMarket();

	Market getMarketByMid(Integer mid);

	void UpdateMarket(Market market);

	void DeleteMarket(Integer mid);

	List<BuyInfor> SelectAllBuyInfor();
	
	BuyInfor selectBuyInfor(Integer bid);

	List<SendInfor> SelectAllSendInfor();

	List<Employee> selectAllEmp();

	Boolean insertEmp(Employee emp);

	Employee getEmpByEid(Integer eid);

	void updateEmp(Employee emp);

	void deleteEmp(Integer eid);
	
	void insertGiveInfor(Give give);
	
	List<Give> selectAllGiveInfor();
	
	List<Receive> selectAllReceive();
}
