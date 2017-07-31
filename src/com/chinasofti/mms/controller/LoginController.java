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
import com.chinasofti.mms.util.TransferUtil;

@Controller
public class LoginController {
	@Autowired
	private RoleService employeeService;
	TransferUtil mdu = new TransferUtil();
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
	//登录
	@RequestMapping("login.action")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		//从页面拿到对应输入的用户名和密码
		String UserName = request.getParameter("username");
		String UserPwd = request.getParameter("userpwd");
		//将密码进行MD5加密处理
		String password = mdu.getMD5(UserPwd);
		//判断输入的用户名和密码是否为空，将其封装进employee对象
		Employee employee = null;
		if(null == UserName ||null == password || "".equals(UserName) || "".equals(password)){
			return new ModelAndView("login");
		}else{
			employee = new Employee(UserName,password);
		}
		//根据用户名和密码到数据库查询用户资料
		Employee loginEmployee = employeeService.login(employee);
		System.out.println(loginEmployee+"查询后的员工信息");
		//对输出的用户进行判断，状态为1时，账号正常，可以登录，2已关闭，0等待审核，除了1以外都不能登录成功
		//将登录成功的用户信息封装进employee对象，方便后面使用
		if(loginEmployee != null&&1==loginEmployee.getEmployeestatus()){
			HttpSession session = request.getSession();
			session.setAttribute("loginUserName", loginEmployee.getUsername());
			session.setAttribute("loginEmployeeId", loginEmployee.getEmployeeid());
			session.setAttribute("phone", loginEmployee.getPhone());
			session.setAttribute("email", loginEmployee.getEmail());
			session.setAttribute("employeestaus", loginEmployee.getEmployeestatus());
			session.setAttribute("roleid", loginEmployee.getRoleid());
			request.setAttribute("loginMessage", "登录成功！");
			return new ModelAndView("forward:notification.action");
		}else if(loginEmployee != null&&0==loginEmployee.getEmployeestatus()){
			request.setAttribute("loginMessage", "账号正在审核中，请耐心等待！");
			return new ModelAndView("login");
		}else if(loginEmployee != null&&2==loginEmployee.getEmployeestatus()){
			request.setAttribute("loginMessage", "账号未通过审核或已关闭，请重新注册！");
			return new ModelAndView("login");
		}else{
			request.setAttribute("loginMessage", "账号或密码不正确，请重新登录！");
			return new ModelAndView("login");
		}
	}
}
