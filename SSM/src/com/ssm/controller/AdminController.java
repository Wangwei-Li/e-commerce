package com.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.bean.BuyInfor;
import com.ssm.bean.Employee;
import com.ssm.bean.Give;
import com.ssm.bean.Market;
import com.ssm.bean.Receive;
import com.ssm.bean.SendInfor;
import com.ssm.bean.User;
import com.ssm.service.AdminService;
import com.ssm.service.LoginService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private LoginService loginService;

	// List<User> getAllUser();得到所有的用户
	@RequestMapping(value = "getAllUser")
	public String getAllUser(Map<String, Object> map) {
		List<User> getAllUser = adminService.getAllUser();
		map.put("getAllUser", getAllUser);
		return "admin/adminIndex_allUser.jsp";
	}

	// List<Market> getAllMarket();得到所有的商家
	@RequestMapping(value = "getAllMarket")
	public String getAllMarket(Map<String, Object> map) {
		List<Market> getAllMarket = adminService.getAllMarket();
		map.put("getAllMarket", getAllMarket);
		return "admin/adminIndex_allMarket.jsp";
	}

	// User getUserByUid(Integer uid);展示所点击的用户信息
	@RequestMapping(value = "getUserByUid/{uid}")
	public ModelAndView getUserByUid(ModelAndView model, @PathVariable("uid") Integer uid) {
		User userByUid = adminService.getUserByUid(uid);
		model.setViewName("../admin/adminIndex_updateUser.jsp");
		model.addObject("userByUid", userByUid);
		return model;
	}

	// void UpdateUser(User user);修改用户信息
	@RequestMapping(value = "UpdateUser")
	public String UpdateUser(User user, HttpServletRequest request) {
		adminService.UpdateUser(user);
		return "redirect:getAllUser";
	}

	// void DeleteUser(Integer uid);删除指定用户
	@RequestMapping(value = "deleteUserByUid/{uid}")
	public String deleteUser(@PathVariable("uid") Integer uid) {
		adminService.DeleteUser(uid);
		return "redirect:../getAllUser";
	}

	// Market getMarketByUid(Integer mid);展示所点击的商家信息
	@RequestMapping(value = "getMarketByMid/{mid}")
	public ModelAndView getMarketByUid(ModelAndView model, @PathVariable("mid") Integer mid) {
		Market marketByMid = adminService.getMarketByMid(mid);
		model.setViewName("../admin/adminIndex_updateMarket.jsp");
		model.addObject("marketByMid", marketByMid);
		return model;
	}

	// void UpdateMarket(Market market);修改商家信息
	@RequestMapping(value = "UpdateMarket")
	public String UpdateMarket(Market market, HttpServletRequest request) {
		adminService.UpdateMarket(market);
		return "redirect:getAllMarket";
	}

	// void DeleteMarket(Integer mid);删除指定商家
	@RequestMapping(value = "deleteMarketByMid/{mid}")
	public String deleteMarket(@PathVariable("mid") Integer mid) {
		adminService.DeleteMarket(mid);
		return "redirect:../getAllMarket";
	}

	// 返回首页
	@RequestMapping(value = "adminHome")
	public String returnHome() {
		return "redirect:admin/adminIndex.jsp";
	}

	// 跳转到商家添加页面
	@RequestMapping(value = "adminInsertMarketJsp")
	public String adminInsertMarket() {
		return "admin/adminIndex_insertMarket.jsp";
	}

	// 添加商家
	@RequestMapping(value = "adminInsertMarket")
	public String insertMarket(Market market) {
		Boolean result = loginService.marketEnrol(market);
		if (result == true) {
			return "getAllMarket";
		} else {
			return "adminInsertMarketJsp";
		}
	}

	// 跳转到用户添加页面
	@RequestMapping(value = "adminInsertUserJsp")
	public String adminInsertUser() {
		return "admin/adminIndex_insertUser.jsp";
	}

	// 添加用户
	@RequestMapping(value = "adminInsertUser")
	public String insertUser(User user) {
		Boolean result = loginService.userEnrol(user);
		if (result == true) {
			return "getAllUser";
		} else {
			return "adminInsertUserJsp";
		}
	}

	// 离开商家添加页面
	@RequestMapping(value = "adminLeaveInsertMarket")
	public String leaveMarket() {
		return "redirect:getAllMarket";
	}

	// 离开用户添加页面
	@RequestMapping(value = "adminLeaveInsertUser")
	public String leaveUser() {
		return "redirect:getAllUser";
	}
	//查看所有订单
	@RequestMapping(value = "adminAllBuyInfor")
	public String adminAllBuyInfor(Map<String,Object> map) {
		List<BuyInfor> selectAllBuyInfor = adminService.SelectAllBuyInfor();
		map.put("selectAllBuyInfor", selectAllBuyInfor);
		return "admin/adminIndex_allBuyInfor.jsp";
	}
	
	//查看商家发货记录
	@RequestMapping(value = "adminAllSendInfor")
	public String adminAllSendInfor(Map<String,Object> map) {
		List<SendInfor> selectAllSendInfor = adminService.SelectAllSendInfor();
		map.put("selectAllSendInfor", selectAllSendInfor);
		return "admin/adminIndex_allSendInfor.jsp";
	}
	
	//跳转到配送页面
	@RequestMapping(value = "giveGoodsJsp/{bid}")
	public String admingiveGoodsJsp(@PathVariable("bid")Integer bid,Map<String,Object> map,HttpSession session) {
		BuyInfor selectBuyInfor = adminService.selectBuyInfor(bid);
		List<Employee> selectAllEmp = adminService.selectAllEmp();
		session.setAttribute("selectBuyInfor", selectBuyInfor);
		map.put("selectAllEmp", selectAllEmp);
		return "../admin/adminIndex_giveGoods.jsp";
	}
	
	//查看所有的送货员工
	@RequestMapping(value = "adminAllEmployee")
	public String adminAllEmployee(Map<String,Object> map) {
		List<Employee> selectAllEmp = adminService.selectAllEmp();
		map.put("selectAllEmp", selectAllEmp);
		return "admin/adminIndex_allEmployee.jsp";
	}
	
	//跳转到员工添加页
	@RequestMapping(value = "adminInsertEmpJsp")
	public String adminInsertEmpJsp() {
		return "admin/adminIndex_insertEmp.jsp";
	}
	//添加送货员工
	@RequestMapping(value = "adminInsertEmp")
	public String adminInsertEmp(Employee emp) {
		Boolean result = adminService.insertEmp(emp);
		if (result == true) {
			return "adminAllEmployee";
		} else {
			return "adminInsertEmpJsp";
		}
	}
	//跳转到员工信息修改页
	@RequestMapping(value = "adminUpdateEmpJsp/{eid}")
	public String adminUpdateEmpJsp(@PathVariable("eid") Integer eid,HttpSession session) {
		Employee empByEid = adminService.getEmpByEid(eid);
		session.setAttribute("empByEid", empByEid);
		return "../admin/adminIndex_updateEmp.jsp";
	}
	//修改员工信息
	@RequestMapping(value = "updateEmp")
	public String UpdateUser(Employee emp,HttpServletRequest request) {
		String car = request.getParameter("car");
		adminService.updateEmp(emp);
		return "redirect:adminAllEmployee";
	}
	//删除员工
	@RequestMapping(value = "deleteEmp/{eid}")
	public String deleteEmp(@PathVariable("eid") Integer eid) {
		adminService.deleteEmp(eid);
		return "redirect:../adminAllEmployee";
	}
	
	//添加配送信息
	@RequestMapping(value = "insertGiveInfor")
	public String insertGiveInfor(Give give) {
		Date time=new Date();
		String geshi="yyyy年MM月dd日  HH:mm";
		SimpleDateFormat sdf=new SimpleDateFormat(geshi);
		String date=sdf.format(time);
		give.setGtime(date);
		adminService.insertGiveInfor(give);
		return "redirect:adminAllSendInfor";
	}
	
	//查看物品配送状态
	@RequestMapping(value="adminAllGiveInfor")
	public String selectAllGiveInfor(Map<String,Object> map) {
		List<Give> selectAllGiveInfor = adminService.selectAllGiveInfor();
		map.put("selectAllGiveInfor", selectAllGiveInfor);
		return "admin/adminIndex_allGiveInfor.jsp";
	}
	
	//查看货物是否已送达
	@RequestMapping(value="adminAllGiveEnd")
	public String adminAllGiveEnd(Map<String,Object> map) {
		List<Give> selectAllGiveInfor = adminService.selectAllGiveInfor();
		map.put("selectAllGiveInfor", selectAllGiveInfor);
		return "admin/adminIndex_allGiveEnd.jsp";
	}
	
	//查看用户是否签收
	@RequestMapping(value="adminAllReceive")
	public String adminAllReceive(Map<String,Object> map) {
		List<Receive> selectAllReceive = adminService.selectAllReceive();
		map.put("selectAllReceive", selectAllReceive);
		return "admin/adminIndex_allReceive.jsp";
	}
	
}
