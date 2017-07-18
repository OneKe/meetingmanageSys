package com.chinasofti.mms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.service.RoleService;

@Controller
public class LoginController {
	@RequestMapping("index.action")
	public ModelAndView index(){
		return new ModelAndView("login");
	}
	
	@RequestMapping("login.action")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		String UserName = request.getParameter("username");
		String UserPwd = request.getParameter("userpwd");
		Employee employee = null;
		if(null == UserName ||null == UserPwd || "".equals(UserName) || "".equals(UserPwd)){
			return new ModelAndView("login");
		}else{
			employee = new Employee(UserName,UserPwd);
		}
		RoleService employeeService = new RoleService();
		Employee loginEmployee = employeeService.login(employee);
		if(loginEmployee != null){
			HttpSession session = request.getSession();
			session.setAttribute("loginUserName", loginEmployee.getUsername());
			session.setAttribute("loginEmployeeId", loginEmployee.getEmployeeid());
			session.setAttribute("phone", loginEmployee.getPhone());
			session.setAttribute("email", loginEmployee.getEmail());
			session.setAttribute("employeestaus", loginEmployee.getEmployeestatus());
			request.setAttribute("loginMessage", "登录成功！");
			return new ModelAndView("notification");
		}else{
			request.setAttribute("loginMessage", "登录失败！");
			return new ModelAndView("login");
		}
	}
}
