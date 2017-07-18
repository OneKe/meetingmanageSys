package com.chinasofti.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mms.pojo.Department;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.service.EmployeeService;
import com.chinasofti.mms.util.TransferUtil;

@Controller
@RequestMapping("/jsp")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	TransferUtil tfu = new TransferUtil();
	
	//员工注册
	@RequestMapping("/register.action")
	public String register(Employee employee, Model model) {
		if (employee != null) {
			employee = new Employee(tfu.getUUID(), employee.getEmployeename(), employee.getUsername(),
					tfu.getMD5(employee.getUserpwd()), employee.getPhone(), employee.getEmail(),
					employee.getDepartmentid(), employee.getRoleid(), 0);
			System.out.println(employee);
			int i=service.insert(employee);
			if(i>0){
				model.addAttribute("message", "注册成功");
				return "login";
			}else{
				model.addAttribute("message", "注册失败");
				return "register";
			}
		}
		model.addAttribute("message", "注册失败");
		return "register";
	}

	//测试用户名是否合适
	@RequestMapping("/testusername.action")
	public void testUserName(String username, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (null != username && !"".equals(username)) {
			int i = service.selectEmployeeByUsername(username);
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			jsonObject.put("i", i);
			jsonArray.add(jsonObject);
			// 获得输出流
			PrintWriter out = response.getWriter();
			// 通过 out 对象将 jsonArray 传到前端页面
			out.println(jsonArray.toJSONString());
			out.close();
		}
	}
	
	//获取所有部门
	@RequestMapping("/selectdpm.action")
	public void selectDepart(HttpServletResponse response, HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Department> list = service.selectAllDepart();
		if (list.size() > 0) {
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			jsonObject.put("list", list);
			jsonArray.add(jsonObject);
			// 获得输出流
			PrintWriter out = response.getWriter();
			// 通过 out 对象将 jsonArray 传到前端页面
			out.println(jsonArray.toJSONString());
			out.close();
		}
	}
	
	//查询待审批员工
	@RequestMapping("/searchempbystatus.action")
	public String selectEmpByStatus(Model model){
		List<Employee> list=service.selectEmpByStatus();
		System.out.println(list.size());
		if(list.size()>0){
			model.addAttribute("list", list);
			return "approveaccount";
		}else{
			model.addAttribute("message", "没有待审批员工!");
			return "approveaccount";
		}
	}
	
	//审批员工
	public String approveEmployee(Model model){
		
		return "approveaccount";
	}
}
