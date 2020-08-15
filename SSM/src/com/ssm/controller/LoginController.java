package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.bean.Admin;
import com.ssm.bean.Market;
import com.ssm.bean.User;
import com.ssm.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="logins",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(ModelAndView model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		model.setViewName("redirect:jsp/login.jsp");
		Integer id=Integer.valueOf(request.getParameter("username"));
		String pwd=request.getParameter("password");
		int check=Integer.valueOf(request.getParameter("only"));
		if(check==1) {
			Admin selectAdmin = loginService.selectAdmin(id, pwd);
			if(selectAdmin!=null) {
				session.setAttribute("Admin", selectAdmin);
				model.setViewName("redirect:/admin/adminIndex.jsp");
			}
			return model;
		}else if(check==2) {
			Market selectMarket = loginService.selectMarket(id, pwd);
			if(selectMarket!=null) {
				session.setAttribute("Market", selectMarket);
				model.setViewName("redirect:/market/marketIndex.jsp");
			}
			return model;
		}else {
			User selectUser = loginService.selectUser(id, pwd);
			if(selectUser!=null){
				session.setAttribute("User", selectUser);
				model.setViewName("redirect:/user/userIndex.jsp");
			}
			return model;
		}
	}
	
	@RequestMapping(value="userEnrol",method=RequestMethod.POST)
	public String userEnrol(HttpServletRequest request) {
		Integer uid=Integer.valueOf(request.getParameter("uid"));
		String upwd=request.getParameter("upwd");
		String uname=request.getParameter("uname");
		String sex=request.getParameter("sex");
		String year=request.getParameter("year");
		String uaddress=request.getParameter("uaddress");
		User user=new User(uid, upwd, uname, sex, year, uaddress);
		Boolean result = loginService.userEnrol(user);
		if(result==true) {
			return "redirect:jsp/login.jsp";
		}else {
			return "redirect:jsp/userEnrolJsp.jsp";
		}
	}
	
	@RequestMapping(value="marketEnrol",method=RequestMethod.POST)
	public String marketEnrol(HttpServletRequest request) {
		Integer mid=Integer.valueOf(request.getParameter("mid"));
		String mpwd=request.getParameter("mpwd");
		String mname=request.getParameter("mname");
		String maddress=request.getParameter("maddress");
		Market market=new Market(mid, mpwd, mname, maddress);
		Boolean result = loginService.marketEnrol(market);
		if(result==true) {
			return "redirect:jsp/login.jsp";
		}else {
			return "redirect:jsp/userEnrolJsp.jsp";
		}
	}
	
	@RequestMapping(value="leave",method=RequestMethod.GET)
	public String leave() {
		return "redirect:jsp/login.jsp";
	}
}
