package com.chinasofti.mms.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;

import com.chinasofti.mms.service.MeetingService;

@Controller
public class MeetingController {
	@Autowired
	private MeetingService mservice;

	public MeetingService getMservice() {
		return mservice;
	}

	public void setMservice(MeetingService mservice) {
		this.mservice = mservice;
	}

	@RequestMapping("/mymeeting.action")
	public ModelAndView MyMeeting(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginEmployeeId");
		List<MeetingParticipants> lists = mservice.selectMeetingParticipantsByparticipantId(id);
		List<Meeting> mList = new ArrayList<Meeting>();
		List<String> namelist = new ArrayList<String>();
		Employee employee;
		if (lists != null) {
			for (MeetingParticipants mps : lists) {
				Meeting meet = mservice.findMeetingByMeetingId(mps.getMeetingid());
				if (meet != null) {
					mList.add(meet);
				}
			}
		}
		for (Meeting meeting : mList) {
			employee = mservice.selectEmployeeByUsername(meeting.getReservationistid());
			if (employee != null) {
				namelist.add(employee.getUsername());
			}
		}
		ModelAndView mav = new ModelAndView("mymeeting.jsp");
		mav.addObject("meetings", mList);
		mav.addObject("namelist", namelist);
		return mav;
	}

	@RequestMapping("/searchmeeting.action")
	public String selectMeeting(String meetingname, String roomname, String reservername, String reservefromdate,
			String reservetodate, String meetingfromdate, String meetingtodate, Model model) {
		Map<Object, Object> map=new HashMap<>();
		map.put("meetingname", meetingname);
		map.put("roomname", roomname);
		map.put("reservername", reservername);
		map.put("reservefromdate", reservefromdate);
		map.put("reservetodate", reservetodate);
		map.put("meetingfromdate", meetingfromdate);
		map.put("meetingtodate", meetingtodate);
		System.out.println("meetingname:"+meetingname);
		List<Map<String, Object>> list=mservice.selectMeet(map);
		model.addAttribute("list", list);
		return "searchmeetings";
	}
}
