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
		ModelAndView mv = new ModelAndView("mymeetingdetails");
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
		mv.addObject("meetingid", meetingId);
		 		return mv;
		 	}
		 	
		 	@RequestMapping("cancelmeettransfer.action")
		 	public ModelAndView cancelMeetTransfer(HttpServletRequest request,HttpServletResponse response){
		 		ModelAndView mv = new ModelAndView("cancelmeeting");
		 		String mtid = request.getParameter("meetingid");
		 		Meeting meetings = service.selectByMyMeetingById(mtid);
		 		mv.addObject("meetings", meetings);
		 		return mv;
		 	}
		 	
		 	@RequestMapping("cancelmeeting.action")
		 	public ModelAndView cancelMeeting(HttpServletRequest request,HttpServletResponse response){
		 		ModelAndView mv = new ModelAndView("cancelmeeting");
		 		String mtid = request.getParameter("meetingid");
		 		String canceledreson =request.getParameter("canceledreson");
		 		System.out.println("******canceledreson"+canceledreson);
		 		int mt = service.cancelOneMeeting(mtid,canceledreson);
		 		System.out.println(mt);
		 		if(mt>0){
		 			mv.addObject("message", "会议取消成功！");
		 		}else{
		 			mv.addObject("message", "会议失败成功！");
		 		}
		 		mv.addObject("meetingid", mtid);
		return mv;
	}

}
