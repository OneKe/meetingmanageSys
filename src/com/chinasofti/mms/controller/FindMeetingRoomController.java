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
	@RequestMapping("ConfirmTheChange.action")
	public ModelAndView ConfirmTheChange(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv =new ModelAndView("forward:findMeetingRoom.action");
		String roomid = request.getParameter("roomid");
		String roomnumber = request.getParameter("roomnumber");
		String roomname = request.getParameter("roomname");
		String roomcapacity = request.getParameter("roomcapacity");
		String status = request.getParameter("status");
		String description = request.getParameter("description");
		System.out.println("roomid"+roomid);
		System.out.println("roomcapacity"+roomcapacity); 
		System.out.println("status"+status);
		
		int capacity =  Integer.parseInt(roomcapacity);
		int sta =  Integer.parseInt(status);
		
		MeetingRoom mr =  new MeetingRoom(roomid,roomnumber,roomname,capacity,sta,description);
		int i = service.updateMeetingRoom(mr);

			if(i==0){
				mv.addObject("message", "修改失败！");
			}else{
				mv.addObject("message", "修改成功！");
				
			}
			return mv;
	}
}
