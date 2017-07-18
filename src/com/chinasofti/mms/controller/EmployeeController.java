package com.chinasofti.mms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.mms.pojo.Employee;

@Controller
@RequestMapping("/jsp")
public class EmployeeController {
	@RequestMapping("/register.action")
	public String register(Employee employee,Model model){
		System.out.println(employee);
		return "login";
	}
	
	@RequestMapping("/testusername.action")
	public void testUserName(String username){
		System.out.println(username);
		if(null!=username&&!"".equals(username)){
			
		}
	}
}
