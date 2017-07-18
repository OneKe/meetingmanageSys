package com.chinasofti.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

@Controller
@RequestMapping("/jsp")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@RequestMapping("/register.action")
	public String register(Employee employee, Model model) {
		System.out.println(employee);
		return "login";
	}

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
			System.out.println(jsonArray);
			// 获得输出流
			PrintWriter out = response.getWriter();
			// 通过 out 对象将 jsonArray 传到前端页面
			out.println(jsonArray.toJSONString());
			out.close();
		}
	}
}
