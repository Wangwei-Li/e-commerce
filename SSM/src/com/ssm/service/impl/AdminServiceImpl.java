package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Employee;
import com.ssm.bean.Give;
import com.ssm.bean.Market;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.bean.User;
import com.ssm.mapper.AdminMapper;
import com.ssm.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public User getUserByUid(Integer uid) {
		return adminMapper.getUserByUid(uid);
	}
	
	@Override
	public List<User> getAllUser() {
		return adminMapper.getAllUser();
	}

	@Override
	public void UpdateUser(User user) {
		adminMapper.UpdateUser(user);
	}

	@Override
	public void DeleteUser(Integer uid) {
		adminMapper.DeleteUser(uid);
	}

	@Override
	public List<Market> getAllMarket() {
		return adminMapper.getAllMarket();
	}
	
	@Override
	public Market getMarketByMid(Integer mid) {
		return adminMapper.getMarketByMid(mid);
	}
	
	@Override
	public void UpdateMarket(Market market) {
		adminMapper.UpdateMarket(market);
	}


	@Override
	public void DeleteMarket(Integer mid) {
		adminMapper.DeleteMarket(mid);
	}
	
	@Override
	public List<BuyInfor> SelectAllBuyInfor() {
		return adminMapper.SelectAllBuyInfor();
	}
	
	@Override
	public List<SendInfor> SelectAllSendInfor() {
		return adminMapper.SelectAllSendInfor();
	}

	@Override
	public List<Employee> selectAllEmp() {
		return adminMapper.selectAllEmp();
	}

	@Override
	public Boolean insertEmp(Employee emp) {
		Employee empByEid = adminMapper.getEmpByEid(emp.getEid());
		if(empByEid==null) {
			adminMapper.insertEmp(emp);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Employee getEmpByEid(Integer eid) {
		return adminMapper.getEmpByEid(eid);
	}

	@Override
	public void updateEmp(Employee emp) {
		adminMapper.updateEmp(emp);
	}

	@Override
	public void deleteEmp(Integer eid) {
		adminMapper.deleteEmp(eid);
	}

	@Override
	public BuyInfor selectBuyInfor(Integer bid) {
		return adminMapper.selectBuyInfor(bid);
	}

	@Override
	public void insertGiveInfor(Give give) {
		Give selectOneGive = adminMapper.selectOneGive(give.getBuy().getBid());
		if(selectOneGive==null) {
			adminMapper.insertGiveInfor(give);
		}
	}

	@Override
	public List<Give> selectAllGiveInfor() {
		return adminMapper.selectAllGiveInfor();
	}

	@Override
	public List<Receive> selectAllReceive() {
		return adminMapper.selectAllReceive();
	}

}
