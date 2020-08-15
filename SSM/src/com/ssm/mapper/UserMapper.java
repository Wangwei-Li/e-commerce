package com.ssm.mapper;

import java.util.List;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Give;
import com.ssm.bean.Goods;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.bean.User;

public interface UserMapper {

	// �޸ĸ�����Ϣ
	void updateMyUser(User user);

	// �鿴������Ʒ
	List<Goods> userSelectAllGoods();

	// ��ȡ����Ʒ��Ϣ
	Goods userSelectGoods(Integer gid);

	// ������Ʒ������������Ϣ
	void insertBuyInfor(BuyInfor buyInfor);

	// �鿴���˹�����Ϣ
	List<BuyInfor> selectUserBuyInfor(Integer uid);

	// �鿴�̼ҷ�����Ϣ
	List<SendInfor> userSelectAllSendInfor(Integer uid);

	// �鿴��Ʒ�������
	List<Give> userSelectGive(Integer uid);

	// �鿴�Ƿ���ǩ�մ˶���
	Integer userSelectOneReceive(Integer bid);

	// ǩ����Ʒ������Ϣ����ǩ�ձ���
	void userInsertReceive(Integer bid, String rtime);

	// �鿴��ǩ�����
	List<Receive> userSelectReceive(Integer uid);

	// �鿴��־
	String userSelectLogs(Integer uid);

	// �鿴�Ƿ����
	Integer userSelectUserLog(Integer uid);

	// �޸���־
	void userUpdateLogs(String log, Integer uid);

	// �����־
	void userInsertLogs(Integer uid);
}
