package com.chinasofti.mms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.service.RoleService;

@Controller
public class FindAllEmployeesController {

	@Autowired
	private RoleService service;
	
	public RoleService getService() {
		return service;
	}

	public void setService(RoleService service) {
		this.service = service;
	}
	
	@RequestMapping("searchemployees.action")
	public ModelAndView findEmployees(HttpServletRequest request,HttpServletResponse response){
		
	ModelAndView mv = new ModelAndView("searchemployees");
	//从页面拿值
	String employeeName = request.getParameter("employeename");
	String accountName = request.getParameter("accountname");
	String status = request.getParameter("status");
	String pageSize = request.getParameter("pagesize");
	String pageIndex = request.getParameter("pageindex");
	//判断是否为空，设置默认值
	if(null == employeeName){
		employeeName = "";
	}
	if(null == accountName){
		accountName = "";
	}
	if(null == status){
		status = "1";
	}
	if(null == pageIndex){
		pageIndex = "1";
	}
	if(null == pageSize){
		pageSize = "8";
	}
	//将账号状态，每页展示页，开始位置 转换为int类型，作为参数
	int intStatus = Integer.parseInt(status);
	int intPageSize = Integer.parseInt(pageSize);
	int intpageIndex = Integer.parseInt(pageIndex);
	int pstart =intPageSize * (intpageIndex - 1);
	int psize =intPageSize;
	
	//将多个参数封装进map中
	Map<String,Object> paramMap=new HashMap<String,Object>();
	paramMap.put("employeeName",employeeName);
	paramMap.put("accountName",accountName);
	paramMap.put("intStatus",intStatus);
	paramMap.put("pstart",pstart);
	paramMap.put("psize",psize);
	
	//按条件去数据库查询符合条件的用户
	List<Employee> list = service.findEmployee(paramMap);
	
	//将从数据库查询到的值，写进request中，页面取值
	request.setAttribute("list", list);
	request.setAttribute("pageindex", psize);
	for (Employee employee : list) {
		System.out.println(employee);
	}
	
	return mv;
	}
	
	@RequestMapping("closeemployee.action")
	public ModelAndView CloseAccount(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("searchemployees");
		String id  = request.getParameter("id");
		if(null == id || "".equals(id)){
			request.setAttribute("message", "id为空！");
			return mv;
		}
		int isClosed = service.updateEmployeeStatus(id, 3);
		if(isClosed>0){
			request.setAttribute("message", "关闭成功！");
			return mv;
		}else{
			request.setAttribute("message", "关闭失败！");
			return mv;
		}
		
	}
	
}
