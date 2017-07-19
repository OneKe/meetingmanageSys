package com.chinasofti.mms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;
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
		List<MeetingParticipants> mpList = new ArrayList<MeetingParticipants>();
		mpList = service.selectMeetingParticipantsByparticipantId(id);
		List<Meeting> mList = new ArrayList<Meeting>();
		List<String> ur = new ArrayList<String>();
		List<String> cr = new ArrayList<String>();
		
		if (mpList != null) {
			for (MeetingParticipants meetingParticipants : mpList) {
				Meeting m = service.comingMeeting(meetingParticipants.getMeetingid());
				
				if (m != null) {
					mList.add(m);
					String roomname=service.selectRoomNameByid(m.getRoomid());
					ur.add(roomname);
				}
			}
		}
		
		
		List<Meeting> cancellist = new ArrayList<Meeting>();
		cancellist = service.cancelMeeting();
		for (Meeting meet : cancellist) {
			String cancelroom=service.selectRoomNameByid(meet.getRoomid());
			cr.add(cancelroom);
		}
		if (cancellist.size() > 0) {
			mv.addObject("cancellist", cancellist);
		} else {
			mv.addObject("cancelmessage", "没有取消的会议!");
		}
		if (mList.size() > 0) {
			mv.addObject("meetinglist", mList);
		} else {
			mv.addObject("meetingmessage", "未来7天没有要参加的会议!");
		}
		System.out.println(cr+"********************");
		mv.addObject("ur", ur);
		mv.addObject("cr", cr);
		
		
		return mv;
	}
	

}
