package com.chinasofti.mms.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.MeetingRoom;
import com.chinasofti.mms.service.FindMeetingService;
import com.chinasofti.mms.service.MeetingRoomService;


@Controller
public class FindMeetingRoomController {
	@Autowired
    private FindMeetingService fservice;
	private Object meetingRoom;

	public FindMeetingService getFservice() {
		return fservice;
	}

	public void setFservice(FindMeetingService fservice) {
		this.fservice = fservice;
	}
	
	@RequestMapping("roomdetails.action")
	public ModelAndView findEmployees(MeetingRoom meetingRoom,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView("roomdetails");
		mav.addObject("meetingroom",meetingRoom);
		
		return mav;
	
		
	}
		
}
