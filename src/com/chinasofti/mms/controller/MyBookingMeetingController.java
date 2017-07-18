package com.chinasofti.mms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MyBookingMeetingController {
		
	@RequestMapping("mybooking.action")
	public ModelAndView MyBooking(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("loginEmployeeId");
		ModelAndView mv=new ModelAndView("mybookings.jsp");
		return mv;
	}
}
