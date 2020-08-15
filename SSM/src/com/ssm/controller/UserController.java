package com.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Give;
import com.ssm.bean.Goods;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.bean.User;
import com.ssm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 返回首页
	@RequestMapping(value = "userHome")
	public String userHome() {
		return "redirect:user/userIndex.jsp";
	}

	// 跳转到个人信息显示页(不可修改)
	@RequestMapping(value = "myUser")
	public String myUser() {
		return "user/userIndex_myUser.jsp";
	}

	// 跳转到个人信息修改页(可修改)
	@RequestMapping(value = "myUserUpdate")
	public String myUserUpdate() {
		return "user/userIndex_myUserUpdate.jsp";
	}

	// 修改自身信息
	@RequestMapping(value = "updateMyUser")
	public String updateMyUser(User user, HttpSession session) {
		userService.updateMyUser(user);
		session.setAttribute("User", user);
		return "redirect:myUser";
	}

	// 浏览商品
	@RequestMapping(value = "userSelectAllGoods")
	public String userSelectAllGoods(Map<String, Object> map) {
		List<Goods> userSelectAllGoods = userService.userSelectAllGoods();
		map.put("AllGoods", userSelectAllGoods);
		return "user/userIndex_myUserAllGoods.jsp";
	}

	// 跳转到商品购买页
	@RequestMapping(value = "buyGoods/{gid}")
	public String buyGoods(Model model, @PathVariable("gid") Integer gid) {
		Goods goods = userService.userSelectGoods(gid);
		model.addAttribute("goods", goods);
		return "../user/userIndex_buyGoods.jsp";
	}

	// 购买商品，添加订单信息
	@RequestMapping(value = "insertBuyInfor")
	public String insertBuyInfor(BuyInfor buyInfor) {
		userService.insertBuyInfor(buyInfor);
		return "redirect:userSelectAllGoods";
	}

	// 查看自身所有订单
	@RequestMapping(value = "selectUserBuyInfor/{uid}")
	public String selectUserBuyInfor(Map<String, Object> map, @PathVariable("uid") Integer uid) {
		List<BuyInfor> selectUserBuyInfor = userService.selectUserBuyInfor(uid);
		map.put("userBuyInfor", selectUserBuyInfor);
		return "../user/userIndex_myUserBuyInfor.jsp";
	}

	// 查看商家发货情况
	@RequestMapping(value = "selectMarketSendInfors/{uid}")
	public String selectMarketSendInfors(Map<String, Object> map, @PathVariable("uid") Integer uid) {
		List<SendInfor> userSelectAllSendInfor = userService.userSelectAllSendInfor(uid);
		map.put("userSelectAllSendInfor", userSelectAllSendInfor);
		return "../user/userIndex_myUserSendInfor.jsp";
	}

	// 查看物品派送情况
	@RequestMapping(value = "userGive/{uid}")
	public String userGive(Map<String, Object> map, @PathVariable("uid") Integer uid) {
		List<Give> userSelectGive = userService.userSelectGive(uid);
		map.put("userSelectGive", userSelectGive);
		return "../user/userIndex_myUserGive.jsp";
	}

	// 查看货物送达情况
	@RequestMapping(value = "userGiveEnd/{uid}")
	public String userGiveEnd(Map<String, Object> map, @PathVariable("uid") Integer uid) {
		List<Give> userSelectGiveEnd = userService.userSelectGive(uid);
		map.put("userSelectGiveEnd", userSelectGiveEnd);
		return "../user/userIndex_myUserGiveEnd.jsp";
	}

	// 签收物品，把订单编号存入签收表中
	@RequestMapping(value = "userInsertReceive/{bid}/{uid}")
	public String userInsertReceive(@PathVariable("bid") Integer bid, @PathVariable("uid") Integer uid) {
		Date time = new Date();
		String geshi = "yyyy年MM月dd日  HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(geshi);
		String date = sdf.format(time);
//		Receive receive=new Receive();
//		receive.getBuy().setBid(bid);
//		receive.setRtime(date);
		userService.userInsertReceive(bid, date);
		return "redirect:../../userGiveEnd/" + uid + "";
	}

	// 查看已签收情况
	@RequestMapping(value = "userReceive/{uid}")
	public String userReceive(Map<String, Object> map, @PathVariable("uid") Integer uid) {
		List<Receive> userSelectReceive = userService.userSelectReceive(uid);
		map.put("userSelectReceive", userSelectReceive);
		return "../user/userIndex_myUserReceive.jsp";
	}

	// 查看日志
	@RequestMapping(value = "userSelectLogs/{uid}")
	public String userSelectLogs(@PathVariable("uid") Integer uid, HttpSession session) {
		String log = userService.userSelectLogs(uid);
		session.setAttribute("userlogs", log);
		return "../user/userIndex_myLogs.jsp";
	}

	// 修改日志
	@RequestMapping(value = "updateUserLog/{uid}")
	public String marketUpdateLogs(@PathVariable("uid") Integer uid, HttpServletRequest request) {
		String log = request.getParameter("userlogs");
		userService.userUpdateLogs(log, uid);
		return "redirect:../userSelectLogs/" + uid + "";
	}
}
