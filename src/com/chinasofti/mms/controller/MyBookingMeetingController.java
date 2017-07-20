package com.chinasofti.mms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.service.RoleService;

@Controller

public class MyBookingMeetingController {
	@Autowired
	private RoleService rs;
	
	public RoleService getRs() {
		return rs;
	}

	public void setRs(RoleService rs) {
		this.rs = rs;
	}

	@RequestMapping("/mybooking.action")
	public ModelAndView MyBooking(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginEmployeeId");
		List<Meeting> mList = rs.selectByEmployeeName(id);
		ModelAndView mv=new ModelAndView("mybookings");
		mv.addObject("bookinglist", mList);
		return mv;
	}
}
