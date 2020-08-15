package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Give;
import com.ssm.bean.Goods;
import com.ssm.bean.Market;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.mapper.MarketMapper;
import com.ssm.service.MarketService;

@Service
public class MarketServiceImpl implements MarketService {
	
	@Autowired
	MarketMapper marketMapper;

	@Override
	public Market selectMyMarket(Integer mid) {
		return marketMapper.selectMyMarket(mid);
	}

	@Override
	public void updateMyMarket(Market market) {
		marketMapper.updateMyMarket(market);
		
	}

	@Override
	public List<Goods> selectMyGoods(Integer mid) {
		return marketMapper.selectMyGoods(mid);
	}

	@Override
	public Goods selectOne(Integer gid) {
		return marketMapper.selectOne(gid);
	}

	@Override
	public Boolean insertGoods(Goods goods) {
		Goods selectOne = marketMapper.selectOne(goods.getGid());
		if(selectOne!=null) {
			return false;
		}else {
			marketMapper.insertGoods(goods);
			return true;
		}
	}

	@Override
	public void updateGoods(Goods goods) {
		marketMapper.updateGoods(goods);
	}

	@Override
	public void deleteGoods(Integer gid) {
		marketMapper.deleteGoods(gid);
	}
	
	@Override
	public List<BuyInfor> selectBuyInfors(Integer mid) {
		return marketMapper.selectBuyInfors(mid);
	}

	@Override
	public void insertSendInfor(Integer bid) {
		SendInfor selectResult = marketMapper.selectResult(bid);
		if(selectResult==null) {
			marketMapper.insertSendInfor(bid);
		}
	}
	
	@Override
	public List<SendInfor> selectSendInfors(Integer mid) {
		return marketMapper.selectSendInfors(mid);
	}

	@Override
	public List<Give> marketSelectGive(Integer mid) {
		return marketMapper.marketSelectGive(mid);
	}

	@Override
	public List<Receive> marketSelectReceive(Integer mid) {
		return marketMapper.marketSelectReceive(mid);
	}

	@Override
	public String marketSelectLogs(Integer mid) {
		Integer market = marketMapper.marketSelectMarketLog(mid);
		if(market==null) {
			marketMapper.marketInsertLogs(mid);
		}
		return marketMapper.marketSelectLogs(mid);
	}

	@Override
	public void marketUpdateLogs(String log,Integer mid) {
		marketMapper.marketUpdateLogs(log,mid);
	}
}
