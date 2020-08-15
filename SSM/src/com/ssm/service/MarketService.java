package com.ssm.service;

import java.util.List;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Give;
import com.ssm.bean.Goods;
import com.ssm.bean.Market;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;

public interface MarketService {

	// ��ʾ������Ϣ
	Market selectMyMarket(Integer mid);

	// �޸�������Ϣ
	void updateMyMarket(Market market);

	// �鿴��������Ʒ
	List<Goods> selectMyGoods(Integer mid);

	// ������Ʒ��Ų�ѯ��Ʒ
	Goods selectOne(Integer gid);

	// �����Ʒ
	Boolean insertGoods(Goods goods);

	// �޸���Ʒ
	void updateGoods(Goods goods);

	// ɾ����Ʒ
	void deleteGoods(Integer gid);

	// �鿴���й�������
	List<BuyInfor> selectBuyInfors(Integer mid);

	// ����������
	void insertSendInfor(Integer bid);

	// �鿴���з�����Ϣ
	List<SendInfor> selectSendInfors(Integer mid);

	// �鿴��������Ʒ
	List<Give> marketSelectGive(Integer mid);

	// �鿴��ǩ����Ʒ
	List<Receive> marketSelectReceive(Integer mid);

	// �鿴��־
	String marketSelectLogs(Integer mid);

	// �޸���־
	void marketUpdateLogs(String log,Integer mid);

}
