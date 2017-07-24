package com.chinasofti.mms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.MeetingRoom;
import com.chinasofti.mms.service.RoleService;

@Controller
public class FindMeetingRoomController {

	@Autowired
	private RoleService service;
	
	public RoleService getService() {
		return service;
	}

	public void setService(RoleService service) {
		this.service = service;
	}
	
	@RequestMapping("findMeetingRoom.action")
	public ModelAndView findMeetingRoom(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv =new ModelAndView("meetingrooms");
		List<Map<String,Object>> mrList = new ArrayList<Map<String,Object>>();
		mrList = service.selectMeetingRoomAll();
		mv.addObject("meetingroomlist", mrList);
		return mv;
	}
	
	@RequestMapping("oneroomdetails.action")
	public ModelAndView findOneRoomDetail(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv =new ModelAndView("roomdetails");
		String id =request.getParameter("roomid");
		MeetingRoom mr = service.selectOneMeetingRoom(id);
		mv.addObject("meetingroom", mr);
		return mv;
		
	}
}
