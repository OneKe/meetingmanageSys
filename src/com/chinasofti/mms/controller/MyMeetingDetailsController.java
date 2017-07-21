package com.chinasofti.mms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.service.RoleService;  


@Controller
public class MyMeetingDetailsController {
	
	@Autowired
	private RoleService service;
	
	public RoleService getService() {
		return service;
	}

	public void setService(RoleService service) {
		this.service = service;
	}
	
	@RequestMapping("meetingdetails.action")
	public ModelAndView myMeetingDetails(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("meetingdetails");
		String meetingId = request.getParameter("meetingid");
		if(null == meetingId || "".equals(meetingId)){
			meetingId = "0";
		}
		
		//会议详情
		Meeting meetings = service.selectByMyMeetingById(meetingId);
		System.out.println("***************"+meetings);
		mv.addObject("meetings", meetings);
		//参会人员
		List<Employee> employees = service.selectEmployeeByMeetingId(meetingId);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
		mv.addObject("employees", employees);
		return mv;
	}

}
