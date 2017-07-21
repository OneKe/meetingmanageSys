package com.chinasofti.mms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.service.RoleService;


@Controller
public class NotificationController {
	@Autowired
	private RoleService service;
	
	public RoleService getService() {
		return service;
	}

	public void setService(RoleService service) {
		this.service = service;
	}

	@RequestMapping("notification.action")
	public ModelAndView notification(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginEmployeeId");
		ModelAndView mv =new ModelAndView("notifications");
		List<Map<String,Object>> mpList = new ArrayList<Map<String,Object>>();
		mpList = service.selectMeetingParticipantsByparticipantId(id);

		List<Map<String,Object>> cancellists = new ArrayList<Map<String,Object>>();
		cancellists = service.cancelMeetingMap();
		
		if (cancellists.size() > 0) {
			mv.addObject("cancellist", cancellists);
		} else {
			mv.addObject("cancelmessage", "没有取消的会议!");
		}
		if (mpList.size() > 0) {
			mv.addObject("meetinglist", mpList);
		} else {
			mv.addObject("meetingmessage", "未来7天没有要参加的会议!");
		}

		return mv;
	}
	
}
