package com.ssm.controller;

import java.util.List;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ssm.bean.BuyInfor;
import com.ssm.bean.Give;
import com.ssm.bean.Goods;
import com.ssm.bean.Market;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.service.MarketService;

@Controller
public class MarketController {

	@Autowired
	MarketService marketService;

	// �ص���ҳ
	@RequestMapping(value = "marketHome")
	public String returnHome() {
		return "redirect:market/marketIndex.jsp";
	}

	// ��ʾ������Ϣ
	@RequestMapping(value = "myMarket")
	public String selectMyMarket() {
		return "market/marketIndex_myMarket.jsp";
	}

	// ��ת������Ϣ�޸�ҳ��
	@RequestMapping(value = "myMarketUpdate")
	public String selectMyMarketUpdate() {
		return "market/marketIndex_myMarketUpdate.jsp";
	}

	// �޸�������Ϣ
	@RequestMapping(value = "updateMyMarket")
	public String UpdateMarket(Market market, HttpSession session) {
		marketService.updateMyMarket(market);
		session.setAttribute("Market", market);
		return "redirect:myMarket";
	}

	// �鿴�����ϼܵ���Ʒ
	@RequestMapping(value = "selectMyGoods/{mid}")
	public String selectMyGoods(Map<String, Object> map, @PathVariable("mid") Integer mid) {
		List<Goods> selectMyGoods = marketService.selectMyGoods(mid);
		map.put("myGoods", selectMyGoods);
		return "../market/marketIndex_myGoods.jsp";
	}
	
	//��ת����Ʒ���ҳ
	@RequestMapping(value="insertMyGoods")
	public String insertMyGoods() {
		return "market/marketIndex_myGoodsInsert.jsp";
	}
	// �����Ʒ
	@RequestMapping(value = "insertGoods")
	public String insertGoods(Goods goods) {
		Boolean result = marketService.insertGoods(goods);
		if (result == true) {
			return "redirect:selectMyGoods/"+goods.getMarket().getMid()+"";
		} else {
			return "insertMyGoods";
		}
	}

	// ������Ʒ��Ų�ѯ��Ʒ
	@RequestMapping(value = "selectOne/{gid}")//method = RequestMethod.GET
	public String selectOne(@PathVariable("gid") Integer gid, HttpSession session) {
		Goods selectOne = marketService.selectOne(gid);
		session.setAttribute("selectOne", selectOne);
		return "../market/marketIndex_myGoodsUpdate.jsp";
	}

	// �޸���Ʒ
	@RequestMapping(value = "updateGoods")// method = RequestMethod.POST
	public String updateGoods(Goods goods,HttpServletRequest request) {
		marketService.updateGoods(goods);
		return "redirect:selectMyGoods/"+goods.getMarket().getMid()+"";
	}
	
	//ɾ����Ʒ
	@RequestMapping(value="deleteGoods/{gid}")
	public String deleteGoods(@PathVariable("gid")Integer gid) {
		Goods selectOne = marketService.selectOne(gid);
		marketService.deleteGoods(gid);
		return "redirect:../selectMyGoods/"+selectOne.getMarket().getMid()+"";
	}
	
	
	// �鿴�û��Ĺ�����Ϣ
	@RequestMapping(value = "marketSelectBuyInfor/{mid}")
	public String marketSelectBuyInfor(Map<String, Object> map, @PathVariable("mid") Integer mid) {
		List<BuyInfor> marketselectBuyInfors = marketService.selectBuyInfors(mid);
		map.put("marketselectBuyInfors", marketselectBuyInfors);
		return "../market/marketIndex_myBuyInfor.jsp";
	}

	// ����������Ϣ(Ϊ�˷�ֹ�����ظ�����ֻ�е�һ�δ���Ż�ɹ�)
	@RequestMapping(value = "insertSendInfor/{bid}")
	public String insertSendInfor(@PathVariable("bid") Integer bid,HttpSession session) {
		marketService.insertSendInfor(bid);
		Market market = (Market)session.getAttribute("Market");
		return "../marketSelectBuyInfor/"+market.getMid()+"";
	}

	// �鿴�Ѿ����������
	@RequestMapping(value = "selectSendInfors/{mid}")
	public String selectSendInfors(Map<String, Object> map, @PathVariable("mid") Integer mid) {
		List<SendInfor> selectSendInfors = marketService.selectSendInfors(mid);
		map.put("marketSelectMySendInfors", selectSendInfors);
		return "../market/marketIndex_mySendInfor.jsp";
	}
	
	//�鿴�Ѿ������͵���Ʒ
	@RequestMapping(value="marketSelectAllGive/{mid}")
	public String marketSelectAllGive(@PathVariable("mid")Integer mid,Map<String,Object> map) {
		List<Give> marketSelectGive = marketService.marketSelectGive(mid);
		map.put("marketSelectGive", marketSelectGive);
		return "../market/marketIndex_myGive.jsp";
	}
	//�鿴�ʹ����
	@RequestMapping(value="marketSelectAllGiveEnd/{mid}")
	public String marketSelectAllGiveEnd(@PathVariable("mid")Integer mid,Map<String,Object> map) {
		List<Give> marketSelectGiveEnd = marketService.marketSelectGive(mid);
		map.put("marketSelectGiveEnd", marketSelectGiveEnd);
		return "../market/marketIndex_myGiveEnd.jsp";
	}
	//�鿴���͵���Ʒ�Ƿ�ǩ��
	@RequestMapping(value="marketSelectAllReceive/{mid}")
	public String marketSelectAllReceive(@PathVariable("mid")Integer mid,Map<String,Object> map) {
		List<Receive> marketSelectReceive = marketService.marketSelectReceive(mid);
		map.put("marketSelectReceive", marketSelectReceive);
		return "../market/marketIndex_myReceive.jsp";
	}
	
	//�鿴��־
	@RequestMapping(value="selectMyLogs/{mid}")
	public String marketSelectLogs(@PathVariable("mid")Integer mid,HttpSession session) {
		String log = marketService.marketSelectLogs(mid);
		session.setAttribute("marketlogs", log);
		return "../market/marketIndex_myLogs.jsp";
	}
	//�޸���־
	@RequestMapping(value="updateMarketLog/{mid}")
	public String marketUpdateLogs(@PathVariable("mid")Integer mid,HttpServletRequest req) {
		String log = req.getParameter("marketlogs");
		marketService.marketUpdateLogs(log, mid);
		return "redirect:../selectMyLogs/"+mid+"";
	}
}
