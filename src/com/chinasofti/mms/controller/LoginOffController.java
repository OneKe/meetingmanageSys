package com.chinasofti.mms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginOffController {

	@RequestMapping("loginoff.action")
	public ModelAndView loginOff(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
		mv.addObject("message", "退出登录成功！");
		return mv;
	}

}
