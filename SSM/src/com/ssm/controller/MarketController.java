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

	// 回到首页
	@RequestMapping(value = "marketHome")
	public String returnHome() {
		return "redirect:market/marketIndex.jsp";
	}

	// 显示自身信息
	@RequestMapping(value = "myMarket")
	public String selectMyMarket() {
		return "market/marketIndex_myMarket.jsp";
	}

	// 跳转自身信息修改页面
	@RequestMapping(value = "myMarketUpdate")
	public String selectMyMarketUpdate() {
		return "market/marketIndex_myMarketUpdate.jsp";
	}

	// 修改自身信息
	@RequestMapping(value = "updateMyMarket")
	public String UpdateMarket(Market market, HttpSession session) {
		marketService.updateMyMarket(market);
		session.setAttribute("Market", market);
		return "redirect:myMarket";
	}

	// 查看自身上架的商品
	@RequestMapping(value = "selectMyGoods/{mid}")
	public String selectMyGoods(Map<String, Object> map, @PathVariable("mid") Integer mid) {
		List<Goods> selectMyGoods = marketService.selectMyGoods(mid);
		map.put("myGoods", selectMyGoods);
		return "../market/marketIndex_myGoods.jsp";
	}
	
	//跳转到商品添加页
	@RequestMapping(value="insertMyGoods")
	public String insertMyGoods() {
		return "market/marketIndex_myGoodsInsert.jsp";
	}
	// 添加商品
	@RequestMapping(value = "insertGoods")
	public String insertGoods(Goods goods) {
		Boolean result = marketService.insertGoods(goods);
		if (result == true) {
			return "redirect:selectMyGoods/"+goods.getMarket().getMid()+"";
		} else {
			return "insertMyGoods";
		}
	}

	// 根据商品编号查询商品
	@RequestMapping(value = "selectOne/{gid}")//method = RequestMethod.GET
	public String selectOne(@PathVariable("gid") Integer gid, HttpSession session) {
		Goods selectOne = marketService.selectOne(gid);
		session.setAttribute("selectOne", selectOne);
		return "../market/marketIndex_myGoodsUpdate.jsp";
	}

	// 修改商品
	@RequestMapping(value = "updateGoods")// method = RequestMethod.POST
	public String updateGoods(Goods goods,HttpServletRequest request) {
		marketService.updateGoods(goods);
		return "redirect:selectMyGoods/"+goods.getMarket().getMid()+"";
	}
	
	//删除商品
	@RequestMapping(value="deleteGoods/{gid}")
	public String deleteGoods(@PathVariable("gid")Integer gid) {
		Goods selectOne = marketService.selectOne(gid);
		marketService.deleteGoods(gid);
		return "redirect:../selectMyGoods/"+selectOne.getMarket().getMid()+"";
	}
	
	
	// 查看用户的购买消息
	@RequestMapping(value = "marketSelectBuyInfor/{mid}")
	public String marketSelectBuyInfor(Map<String, Object> map, @PathVariable("mid") Integer mid) {
		List<BuyInfor> marketselectBuyInfors = marketService.selectBuyInfors(mid);
		map.put("marketselectBuyInfors", marketselectBuyInfors);
		return "../market/marketIndex_myBuyInfor.jsp";
	}

	// 处理请求消息(为了防止请求重复处理，只有第一次处理才会成功)
	@RequestMapping(value = "insertSendInfor/{bid}")
	public String insertSendInfor(@PathVariable("bid") Integer bid,HttpSession session) {
		marketService.insertSendInfor(bid);
		Market market = (Market)session.getAttribute("Market");
		return "../marketSelectBuyInfor/"+market.getMid()+"";
	}

	// 查看已经处理的请求
	@RequestMapping(value = "selectSendInfors/{mid}")
	public String selectSendInfors(Map<String, Object> map, @PathVariable("mid") Integer mid) {
		List<SendInfor> selectSendInfors = marketService.selectSendInfors(mid);
		map.put("marketSelectMySendInfors", selectSendInfors);
		return "../market/marketIndex_mySendInfor.jsp";
	}
	
	//查看已经被派送的商品
	@RequestMapping(value="marketSelectAllGive/{mid}")
	public String marketSelectAllGive(@PathVariable("mid")Integer mid,Map<String,Object> map) {
		List<Give> marketSelectGive = marketService.marketSelectGive(mid);
		map.put("marketSelectGive", marketSelectGive);
		return "../market/marketIndex_myGive.jsp";
	}
	//查看送达情况
	@RequestMapping(value="marketSelectAllGiveEnd/{mid}")
	public String marketSelectAllGiveEnd(@PathVariable("mid")Integer mid,Map<String,Object> map) {
		List<Give> marketSelectGiveEnd = marketService.marketSelectGive(mid);
		map.put("marketSelectGiveEnd", marketSelectGiveEnd);
		return "../market/marketIndex_myGiveEnd.jsp";
	}
	//查看派送的商品是否被签收
	@RequestMapping(value="marketSelectAllReceive/{mid}")
	public String marketSelectAllReceive(@PathVariable("mid")Integer mid,Map<String,Object> map) {
		List<Receive> marketSelectReceive = marketService.marketSelectReceive(mid);
		map.put("marketSelectReceive", marketSelectReceive);
		return "../market/marketIndex_myReceive.jsp";
	}
	
	//查看日志
	@RequestMapping(value="selectMyLogs/{mid}")
	public String marketSelectLogs(@PathVariable("mid")Integer mid,HttpSession session) {
		String log = marketService.marketSelectLogs(mid);
		session.setAttribute("marketlogs", log);
		return "../market/marketIndex_myLogs.jsp";
	}
	//修改日志
	@RequestMapping(value="updateMarketLog/{mid}")
	public String marketUpdateLogs(@PathVariable("mid")Integer mid,HttpServletRequest req) {
		String log = req.getParameter("marketlogs");
		marketService.marketUpdateLogs(log, mid);
		return "redirect:../selectMyLogs/"+mid+"";
	}
}
