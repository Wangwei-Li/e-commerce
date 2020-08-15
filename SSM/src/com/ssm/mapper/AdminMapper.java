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

	// ��ȡ����User��Ϣ
	List<User> getAllUser();

	// ��ѯΪ��uid��User
	User getUserByUid(Integer uid);

	// �޸�User��Ϣ
	void UpdateUser(User user);

	// ���User
	void InsertUser(User user);

	// ɾ��User
	void DeleteUser(Integer uid);

	// ��ȡ����Market��Ϣ
	List<Market> getAllMarket();

	// ��ѯΪ��mid��Market
	Market getMarketByMid(Integer mid);

	// �޸�Market��Ϣ
	void UpdateMarket(Market market);

	// ���Market
	void InsertMarket(Market market);

	// ɾ��Market
	void DeleteMarket(Integer mid);

	// ��ȡ����Buyinfor
	List<BuyInfor> SelectAllBuyInfor();
	
	//��ȡָ��BuyInfor
	BuyInfor selectBuyInfor(Integer bid);

	// ��ȡ�����̼ҷ�����Ϣ
	List<SendInfor> SelectAllSendInfor();

	// �鿴�����ͻ�Ա��
	List<Employee> selectAllEmp();

	// ����ͻ�Ա��
	void insertEmp(Employee emp);

	// ��ѯΪ��mid��Market
	Employee getEmpByEid(Integer eid);

	// �޸��ͻ�Ա����Ϣ
	void updateEmp(Employee emp);

	// ɾ���ͻ�Ա��
	void deleteEmp(Integer eid);
	
	//�����ͱ��в鿴�Ƿ���ڴ˶���
	Give selectOneGive(Integer bid);
	//���������Ϣ
	void insertGiveInfor(Give give);
	//�鿴������Ϣ
	List<Give> selectAllGiveInfor();
	//�鿴��ǩ�ն���
	List<Receive> selectAllReceive();
}
