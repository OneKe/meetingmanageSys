package com.chinasofti.mms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.service.RoleService;

@Controller
public class LoginController {
	@Autowired
	private RoleService employeeService;
	
	public RoleService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(RoleService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping("/index.action")
	public String index(){
		return "login";
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
		
		Employee loginEmployee = employeeService.login(employee);
		System.out.println(loginEmployee+"查询后的员工信息");
		if(loginEmployee != null&&1==loginEmployee.getEmployeestatus()){
			HttpSession session = request.getSession();
			session.setAttribute("loginUserName", loginEmployee.getUsername());
			session.setAttribute("loginEmployeeId", loginEmployee.getEmployeeid());
			session.setAttribute("phone", loginEmployee.getPhone());
			session.setAttribute("email", loginEmployee.getEmail());
			session.setAttribute("employeestaus", loginEmployee.getEmployeestatus());
			request.setAttribute("loginMessage", "登录成功！");
			return new ModelAndView("forward:notification.action");
		}else{
			request.setAttribute("loginMessage", "登录失败！");
			return new ModelAndView("login");
		}
	}
}
